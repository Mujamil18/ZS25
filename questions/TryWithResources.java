package com.daily.questions;

public class TryWithResources {
    public static void main(String[] args) {
        var resource = new AutoCloseableExample();
        try(resource){
            resource.work();
        }
        catch(Exception e){
            System.out.println("error occurred");
        }
//        try(AutoCloseableExample resource = new AutoCloseableExample()){
//            resource.work();
//        }
//        catch(Exception e){
//            System.out.println("error occured");
//        }
    }
}
class AutoCloseableExample implements AutoCloseable{
    public void close(){
        System.out.println("in close()");
        throw new RuntimeException("Exception while closing");
    }
    public void work(){
        System.out.println("in work()");
        throw new RuntimeException(("Exception while work()"));
    }
}
