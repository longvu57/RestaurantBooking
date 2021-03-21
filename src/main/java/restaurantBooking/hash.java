package restaurantBooking;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class hash {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("levu");
         
        System.out.println(encodedPassword);
 
    }

}
