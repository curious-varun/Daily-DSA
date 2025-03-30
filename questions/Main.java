import java.util.*;

public class Main {
    // Store candidates and jobs
    private static Map<String, Candidate> candidates = new HashMap<>();
    private static List<Job> jobs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Candidate currentUser = null;

    public static void main(String[] args) {
        // Add some predefined jobs
        addPredefinedJobs();

        boolean exit = false;
        while (!exit) {
            if (currentUser == null) {
                System.out.println("\n=== Job Application System ===");
                System.out.println("1. Sign Up");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");

                int choice = getIntInput();
                switch (choice) {
                    case 1:
                        signUp();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                // User logged in
                System.out.println("\n=== Welcome, " + currentUser.name + " ===");
                System.out.println("1. View Available Jobs");
                System.out.println("2. Apply for a Job");
                System.out.println("3. Logout");
                System.out.print("Choose an option: ");

                int choice = getIntInput();
                switch (choice) {
                    case 1:
                        viewJobs();
                        break;
                    case 2:
                        applyForJob();
                        break;
                    case 3:
                        currentUser = null;
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }

        System.out.println("Thank you for using the Job Application System!");
    }

    private static void addPredefinedJobs() {
        // Add Software Engineer job
        List<String> skills1 = new ArrayList<>(Arrays.asList("Java", "Python", "SQL"));
        Job job1 = new Job("Software Engineer", 3, skills1);
        jobs.add(job1);

        // Add Data Scientist job
        List<String> skills2 = new ArrayList<>(Arrays.asList("Python", "R", "Machine Learning"));
        Job job2 = new Job("Data Scientist", 2, skills2);
        jobs.add(job2);

        // Add Web Developer job
        List<String> skills3 = new ArrayList<>(Arrays.asList("JavaScript", "HTML", "CSS"));
        Job job3 = new Job("Web Developer", 1, skills3);
        jobs.add(job3);
    }

    private static void signUp() {
        System.out.println("\n=== Sign Up ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        if (candidates.containsKey(name)) {
            System.out.println("User already exists. Please login.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your experience (in years): ");
        int experience = getIntInput();

        System.out.print("Enter your skills (comma-separated): ");
        String skillsInput = scanner.nextLine();
        List<String> skills = new ArrayList<>(Arrays.asList(skillsInput.split("\\s*,\\s*")));

        Candidate candidate = new Candidate(name, password, experience, skills);
        candidates.put(name, candidate);

        System.out.println("Sign up successful! Please login.");
    }

    private static void login() {
        System.out.println("\n=== Login ===");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Candidate candidate = candidates.get(name);
        if (candidate != null && candidate.password.equals(password)) {
            currentUser = candidate;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private static void viewJobs() {
        System.out.println("\n=== Available Jobs ===");
        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            System.out.println((i + 1) + ". " + job.name);
            System.out.println("   Required Experience: " + job.minimum_experience + " years");
            System.out.println("   Required Skills: " + String.join(", ", job.required_skills));
            System.out.println();
        }
    }

    private static void applyForJob() {
        viewJobs();
        System.out.print("Enter the job number you want to apply for: ");
        int jobIndex = getIntInput() - 1;

        if (jobIndex >= 0 && jobIndex < jobs.size()) {
            Job selectedJob = jobs.get(jobIndex);

            System.out.println("\nApply for Job: " + selectedJob.name);
            System.out.println("Required Experience: " + selectedJob.minimum_experience + " years");
            System.out.println("Candidate Experience: " + currentUser.experience + " years");
            System.out.println("Required Skills: " + String.join(", ", selectedJob.required_skills));
            System.out.println("Candidate Skills: " + String.join(", ", currentUser.skills));

            try {
                selectedJob.validateCandidate(currentUser);
            } catch (ExperienceNotMetException e) {
                System.out.println("Error: ExperienceNotMetException - " + e.getMessage());
            } catch (SkillMismatchException e) {
                System.out.println("Error: SkillMismatchException - " + e.getMessage());
            }
        } else {
            System.out.println("Invalid job selection.");
        }
    }

    // Helper method to handle integer input
    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return 0;
        }
    }
}

// Custom exceptions
class ExperienceNotMetException extends Exception {
    public ExperienceNotMetException(String message) {
        super(message);
    }
}

class SkillMismatchException extends Exception {
    public SkillMismatchException(String message) {
        super(message);
    }
}

class Candidate {
    String name;
    String password;
    int experience;
    List<String> skills;

    public Candidate(String name, String password, int experience, List<String> skills) {
        this.name = name;
        this.password = password;
        this.experience = experience;
        this.skills = skills;
    }
}

class Job {
    String name;
    int minimum_experience;
    List<String> required_skills;
    private List<Candidate> valid_candidates;

    public Job(String name, int minimum_experience, List<String> required_skills) {
        this.name = name;
        this.minimum_experience = minimum_experience;
        this.required_skills = required_skills;
        this.valid_candidates = new ArrayList<>();
    }

    public void validateCandidate(Candidate c) throws ExperienceNotMetException, SkillMismatchException {
        if (c.experience < this.minimum_experience)
            throw new ExperienceNotMetException(
                    "Minimum " + this.minimum_experience + " years of experience required.");
        // Check if the candidate has all the required skills
        for (String skill : this.required_skills) {
            if (!c.skills.contains(skill)) {
                throw new SkillMismatchException("Required skills: " +
                        String.join(", ", this.required_skills) + ".");
            }
        }

        // If all checks pass, add the candidate to valid_candidates
        valid_candidates.add(c);
        System.out.println("Application for " + this.name + " by " + c.name + " was successful!");
    }

    // Getter for valid candidates
    public List<Candidate> getValidCandidates() {
        return valid_candidates;
    }
}
