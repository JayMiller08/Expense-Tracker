class User {
    
    private String username, gender;
    private int age;
    


    //constructor to initialize User
    public User(String username, String gender, int age){
        this.username = username;
        this.gender = gender;
        this.age = age;
    }

    //

    public void setUsername(String username){
        this.username = username;
    }

    
    
    //getters for user info
    public String getUsername(){
        return username;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }
}