/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmicalculatorfinal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BMICalculatorFinal {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String choice; 
        
        do {
            
            System.out.println("Welcome to the BMI Calculator System");
            
            String name;
do {
    System.out.print("Enter your Name: ");
    name = input.nextLine();

    if (name.trim().isEmpty()) {
        System.out.println("ERROR: Name cannot be empty! Please try again.");
    } 
    else if (!name.matches("[a-zA-Z ]+")) {
        System.out.println("ERROR: Name must contain letters only! No numbers allowed.");
        name = ""; 
    }

} while (name.trim().isEmpty());
            
           
            int age;
            while (true) {
                System.out.print("Enter your Age: ");
                if (input.hasNextInt()) {
                    age = input.nextInt();
                    input.nextLine();
                    if (age > 0 && age <= 120) {
                        break;
                    } else {
                        System.out.println("ERROR: Age must be between 1-120! Please try again.");
                    }
                } else {
                    System.out.println("ERROR: Age must be a number! Please try again.");
                    input.nextLine(); 
                }
            }
            
            
            String gender;
            while (true) {
                System.out.print("Enter Gender (Male/Female): ");
                String genderInput = input.nextLine().toLowerCase().trim();
                if (genderInput.equals("male") || genderInput.equals("female")) {
                    gender = genderInput.equals("male") ? "Male" : "Female";
                    break;
                } else {
                    System.out.println("ERROR: Please enter only Male or Female! Please try again.");
                }
            }
            
            System.out.println("Greetings " + name + "! Let's check your BMI today.");
            
            
            double weight;
            while (true) {
                System.out.print("Enter Weight (kg): ");
                if (input.hasNextDouble()) {
                    weight = input.nextDouble();
                    input.nextLine();
                    if (weight > 0) {
                        break;
                    } else {
                        System.out.println("ERROR: Weight must be greater than 0! Please try again.");
                    }
                } else {
                    System.out.println("ERROR: Weight must be a number! Please try again.");
                    input.nextLine(); 
                }
            }
            
            
            double height;
            while (true) {
                System.out.print("Enter Height (meters): ");
                if (input.hasNextDouble()) {
                    height = input.nextDouble();
                    input.nextLine();
                    if (height > 0) {
                        break;
                    } else {
                        System.out.println("ERROR: Height must be greater than 0! Please try again.");
                    }
                } else {
                    System.out.println("ERROR: Height must be a number! Please try again.");
                    input.nextLine(); 
                }
            }
            
            double BMI = weight / (height * height);
            
            String category;
            if (BMI < 18.5) {
                category = "Underweight";      
            } 
            else if (BMI >= 18.5 && BMI < 25) {
                category = "Normal Weight";    
            } 
            else if (BMI >= 25 && BMI < 30) {
                category = "Overweight";       
            } 
            else {
                category = "Obese";            
            }
            
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:");
            String currentTime = now.format(formatter);
            
            System.out.println("\n╼╼╼ YOUR RESULTS ╼╼╼");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Gender: " + gender);  
            System.out.println("BMI: " + Math.round(BMI * 100.0) / 100.0); 
            System.out.println("Category: " + category);
            System.out.println("Date and Time: " + currentTime);
            System.out.println("╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼\n");
            
            System.out.print("Do you want to calculate again? (Y/N): ");
            choice = input.nextLine().toUpperCase().trim(); 
            
        } while (choice.equals("Y")); 
        
        System.out.println("Thank you for using the BMI Calculator System.");
        input.close();
    }
}