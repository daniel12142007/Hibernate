package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.save(new Users("da", 19));
        userRepository.save(new Users("Daniel", 19));
//        System.out.println(userRepository.findById(1L));
//        System.out.println(userRepository.findAll());
//        userRepository.deleteById(1L);
//        userRepository.deleteAll();
        userRepository.update(1L,new Users("Daniel",21));
    }
}
