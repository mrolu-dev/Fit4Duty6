import java.util.Scanner;

public class FitForDutyApp {
    public static void main(String[] args) {
        // Get user inputs
        Scanner scanner = new Scanner(System.in);
        System.out.println("FIT FOR DUTY CALCULATOR");
        System.out.println("-----------------------");
        System.out.println("Please select the options for the following factors:");
        
        // Physical Symptoms
        int physicalSymptoms = selectOption("Physical Symptoms", "None", "Mild", "Moderate", "Severe", scanner);
        
        // Cognitive Function
        int cognitiveFunction = selectOption("Cognitive Function", "Normal", "Slight impairment", "Moderate impairment", "Significant impairment", scanner);
        
        // Emotional State
        int emotionalState = selectOption("Emotional State", "Positive", "Neutral", "Negative", scanner);
        
        // Workload Responsibilities
        int workloadResponsibilities = selectOption("Workload Responsibilities", "Low", "Moderate", "High", scanner);
        
        // Environmental Factors
        int environmentalFactors = selectOption("Environmental Factors", "Favorable", "Neutral", "Unfavorable", scanner);
        
        // Personal Factors
        int personalFactors = selectOption("Personal Factors", "Positive", "Neutral", "Negative", scanner);
        scanner.close();
        
        // Calculate fatigue and stress
        int fatigue = calculateFatigue(physicalSymptoms, cognitiveFunction, workloadResponsibilities);
        int stress = calculateStress(emotionalState, environmentalFactors, personalFactors);
        
        // Determine if user is fit for duty
        boolean fitForDuty = isFitForDuty(fatigue, stress);

        if (fitForDuty) {
            System.out.println("You are fit for duty.");
        } else {
            System.out.println("You are not fit for duty. Take appropriate measures before resuming work.");
        }
        
    }
    
    private static int selectOption(String factor, String... options) {
        Scanner scanner = new Scanner(System.in);
        int selectedOption;
        System.out.println("\n" + factor + ":");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Enter your choice (1-" + options.length + "): ");
        
        while (true) {
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option >= 1 && option <= options.length) {
                    break;
                }
            }
            System.out.print("Invalid input. Please enter a number between 1 and " + options.length + ": ");
            scanner.nextLine(); // Clear the input buffer
        }
        
        scanner.nextLine(); // Clear the input buffer
        return option;
    }
    
    private static int calculateFatigue(int physicalSymptoms, int cognitiveFunction, int workloadResponsibilities) {
        return physicalSymptoms + cognitiveFunction + workloadResponsibilities;
    }
    
    private static int calculateStress(int emotionalState, int environmentalFactors, int personalFactors) {
        return emotionalState + environmentalFactors + personalFactors;
    }
    
    private static boolean isFitForDuty(int fatigue, int stress) {
        return fatigue <= 6 && stress <= 6;
    }
    
    private static void renderAdvice(boolean fitForDuty) {
        System.out.println("\nFIT FOR DUTY RESULTS");
        System.out.println("--------------------");
        if (fitForDuty) {
            System.out.println("You are fit for duty.");
        } else {
            System.out.println("You are not fit for duty. Take appropriate measures before resuming work.");
        }
    }
}
