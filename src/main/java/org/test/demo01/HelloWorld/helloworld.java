package org.test.demo01.HelloWorld;

public class helloworld {
    private String username;

    public helloworld() {
        System.out.println("HelloWorld()");
    }

    public helloworld(String username) {
        this.username = username;
        System.out.println("HelloWorld(String)");
    }

    public String getUsername() {
        System.out.println("getUsername()");
        return username;
    }

    public void setUsername1(String username) {
        System.out.println("setUsername()");
        this.username = username;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "username='" + username + '\'' +
                '}';
    }

    public void work(){
        System.out.printf(username+"正在工作...");
    }
}
