package se.lexicon.daniel.ArenaFighter_Assignment3.controller;

import java.time.LocalDate;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.service.FightingService;
import se.lexicon.daniel.ArenaFighter_Assignment3.service.FightingServiceSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.KeyboardInput;

public class FightingController {
	private FightingServiceSignatures fightingServiceInstance;
	private boolean running;
	private Protagonist currentProtagonist;
	private Antagonist currentAntagonist;

	public FightingController() {
		fightingServiceInstance = FightingService.getFightingServiceInstance();

		running = true;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean isStoping() {
		return running = false;
	}

	public void run() {

		fightingServiceInstance.CombatantCreation();

		currentProtagonist = fightingServiceInstance.GetProtagonistObject();
		currentAntagonist = fightingServiceInstance.GetAntagonistObject();
		
		System.out.println("");
		System.out.println("|----------------------|");
		System.out.println("| Arena Battle Round 1 |");
		System.out.println("|----------------------|");
		System.out.println("");

		CombatantSignatures lastTurnOrder = fightingServiceInstance.CombatantInitiative();

		while(currentProtagonist.isAlive() && currentAntagonist.isAlive()) {
			
			if (!currentProtagonist.equals(lastTurnOrder)) {
				lastTurnOrder = currentProtagonist;
				FightingControllerAction(currentProtagonist);
				if (currentProtagonist.getHealth() > -currentProtagonist.getConstitution()) {
					fightingServiceInstance.MeleeAttack(currentProtagonist, currentAntagonist); 
				}
			}
			
			else if (!currentAntagonist.equals(lastTurnOrder)) {
				lastTurnOrder = currentAntagonist;
				FightingControllerAction(currentAntagonist);
				if (currentAntagonist.getHealth() > -currentAntagonist.getConstitution()) {
					fightingServiceInstance.MeleeAttack(currentAntagonist, currentProtagonist); 
				}
			}
		}
		isStoping();
	}

	private void FightingControllerAction(CombatantSignatures CurrentActionTaker) {
		String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
				"\n" +
				" [Attack]    Attack your enemy \n" +
				" [Parry]   Give you a bonus to your defence for the next round \n" +
				" [Study]   Print out your enemis stats \n" +
				" [Surrender]    Beg for your life...\n" +
				"\n" +
				" Your selection... "
				);
		switch (userInput.toLowerCase()) {
		case "attack":
			System.out.println("");
			System.out.println("|-------------------------|");
			System.out.println("| View student or courses |");
			System.out.println("|-------------------------|");
			System.out.println("");
			viewUserInterface();
			break;
		case "parry":
			System.out.println("");
			System.out.println("|-------------------------|");
			System.out.println("| Edit student or courses |");
			System.out.println("|-------------------------|");
			System.out.println("");
			editUserInterface();
			break;
		case "study":
			System.out.println("");
			System.out.println("|---------------------------|");
			System.out.println("| Create student or courses |");
			System.out.println("|---------------------------|");
			System.out.println("");
			createUserInterface();
			break;
		case "surrender":
			System.out.println("");
			System.out.println("|----------------------------|");
			System.out.println("| Terminating the program... |");
			System.out.println("|----------------------------|");
			System.out.println("");
			setRunning(false);
			break;
		default:
			System.out.println("");
			System.out.println("|-------------------|");
			System.out.println("| No such choice... |");
			System.out.println("|-------------------|");
			System.out.println("");
		}
	}
	public void viewUserInterface() {
		boolean stopLoop = false;
		while(!stopLoop) {
			String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
					"\n" +
					" [Student]  View specific student. (Identifier needed) \n" +
					" [Students] View student list \n" +
					" [Course]   View specific coruse. (Identifier needed) \n" +
					" [Courses]  View coruse list \n" +
					" [Back]     Immediately go back to starting menu \n" +
					"\n" +
					" Your selection... "
					);
			switch (userInput.toLowerCase()) {

			case "student":
				System.out.println("");
				System.out.println("|--------------------------|");
				System.out.println("| View Specific student... |");
				System.out.println("|--------------------------|");
				System.out.println("");
				String studentName = KeyboardInput.getString(" Write the name of the student! \n" + " Your selection... ");
				System.out.println(schoolServiceInstance.findStudentByName(studentName.toLowerCase().toLowerCase()));
				break;
				
			case "students":
				System.out.println("");
				System.out.println("|----------------------|");
				System.out.println("| View student list... |");
				System.out.println("|----------------------|");
				System.out.println("");
				System.out.println(schoolServiceInstance.findAllStudentModels().toString().toLowerCase());
				break;
			
			case "course":
				System.out.println("");
				System.out.println("|-------------------------|");
				System.out.println("| View Specific coruse... |");
				System.out.println("|-------------------------|");
				System.out.println("");
				String courseName = KeyboardInput.getString(" Write the name of the coruse! \n" + " Your selection... ");
				System.out.println(schoolServiceInstance.findCourseByName(courseName.toLowerCase().toLowerCase()));
				break;
			
			case "courses":
				System.out.println("");
				System.out.println("|---------------------|");
				System.out.println("| View coruse list... |");
				System.out.println("|---------------------|");
				System.out.println("");
				System.out.println(schoolServiceInstance.findAllCourseModels().toString().toLowerCase());
				break;
			
			case "back":
				System.out.println("");
				System.out.println("|--------------------------------|");
				System.out.println("| Going back to starting menu... |");
				System.out.println("|--------------------------------|");
				System.out.println("");
				stopLoop = true;
				break;
				
			default:
				System.out.println("");
				System.out.println("|-------------------|");
				System.out.println("| No such choice... |");
				System.out.println("|-------------------|");
				System.out.println("");
			}
			if (stopLoop) break;
		}
	}
	public void editUserInterface() {
		boolean stopLoop = false;
		while(!stopLoop) {
			String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
					"\n" +
					" [Student] Edit Specific student. (name or id needed) \n" +
					" [Course] Edit Specific coruse. (name or id needed) \n" +
					" [Back] Immediately go back to starting menu \n" +
					"\n" +
					" Your selection... "
					);
			switch (userInput.toLowerCase()) {
			case "student":
				System.out.println("");
				System.out.println("|--------------------------|");
				System.out.println("| Edit Specific student... |");
				System.out.println("|--------------------------|");
				System.out.println("");
				String studentName = KeyboardInput.getString(" Write the name of the student! \n" + " Your selection... ");
				schoolServiceInstance.findStudentByName(studentName);
				schoolServiceInstance.
				
				break;
			case "course":
				System.out.println("");
				System.out.println("|-------------------------|");
				System.out.println("| Edit Specific coruse... |");
				System.out.println("|-------------------------|");
				System.out.println("");
				break;
			case "back":
				System.out.println("");
				System.out.println("|--------------------------------|");
				System.out.println("| Going back to starting menu... |");
				System.out.println("|--------------------------------|");
				System.out.println("");
				stopLoop = true;
				break;
			default:
				System.out.println("");
				System.out.println("|-------------------|");
				System.out.println("| No such choice... |");
				System.out.println("|-------------------|");
				System.out.println("");
			}
			if (stopLoop) break;
		}
	}
	public void createUserInterface() {
		boolean stopLoop = false;
		while(!stopLoop) {
			String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
					"\n" +
					" [Student] Create Specific student. (user input needed) \n" +
					" [Course] Create Specific coruse. (user input needed) \n" +
					" [Back] Immediately go back to starting menu \n" +
					"\n" +
					" Your selection... "
					);
			switch (userInput.toLowerCase()) {
			case "student":
				System.out.println("");
				System.out.println("|----------------------------|");
				System.out.println("| Create Specific student... |");
				System.out.println("|----------------------------|");
				System.out.println("");
				
				String userInputStudentName = KeyboardInput.getString(" [Student Name?]: ");
				String userInputStudentEmail = KeyboardInput.getString(" [Student Email?]: ");
				String userInputStudentAddress = KeyboardInput.getString(" [Student Address?]: ");
				schoolServiceInstance.registerNewStudent(userInputStudentName, userInputStudentEmail, userInputStudentAddress);
				
				System.out.println("");
				System.out.println("|----------------------------------|");
				System.out.println("| Finished Creating new student... |");
				System.out.println("|----------------------------------|");
				System.out.println("");
				break;
				
			case "course":
				System.out.println("");
				System.out.println("|---------------------------|");
				System.out.println("| Create Specific coruse... |");
				System.out.println("|---------------------------|");
				System.out.println("");
				
				String userInputCourseName = KeyboardInput.getString("[Course Name?]: ");
				LocalDate userInputCourseStartDate = KeyboardInput.getLocalDate("[Date]: ");
				int userInputCourseWeekDuration = KeyboardInput.StringToInt(KeyboardInput.getString("[Weeks]: "));
				schoolServiceInstance.registerNewCourse(userInputCourseName, userInputCourseStartDate, userInputCourseWeekDuration);
				
				System.out.println("");
				System.out.println("|---------------------------------|");
				System.out.println("| Finished Creating new coruse... |");
				System.out.println("|---------------------------------|");
				System.out.println("");
				break;
			case "back":
				System.out.println("");
				System.out.println("|--------------------------------|");
				System.out.println("| Going back to starting menu... |");
				System.out.println("|--------------------------------|");
				System.out.println("");
				stopLoop = true;
				break;
			default:
				System.out.println("");
				System.out.println("|-------------------|");
				System.out.println("| No such choice... |");
				System.out.println("|-------------------|");
				System.out.println("");
			}
			if (stopLoop) break;
		}
	}
	public void removeUserInterface() {
		boolean stopLoop = false;
		while(!stopLoop) {
			String userInput = KeyboardInput.getString(" What action do you want to take? \n" +
					"\n" +
					" [Student] Remove Specific student. (name or id needed) \n" +
					" [Course] Remove Specific coruse. (name or id needed) \n" +
					" [Student-Course] Remove Specific student from course. (name or id needed from both) \n" +
					" [Back] Immediately go back to starting menu \n" +
					"\n" +
					" Your selection... "
					);
			switch (userInput.toLowerCase()) {
			case "student":
				System.out.println("");
				System.out.println("|----------------------------|");
				System.out.println("| Remove Specific student... |");
				System.out.println("|----------------------------|");
				System.out.println("");
				break;
			case "course":
				System.out.println("");
				System.out.println("|---------------------------|");
				System.out.println("| Remove Specific coruse... |");
				System.out.println("|---------------------------|");
				System.out.println("");
				break;
			case "student-course":
				System.out.println("");
				System.out.println("|----------------------------------------|");
				System.out.println("| Remove Specific student from course... |");
				System.out.println("|----------------------------------------|");
				System.out.println("");
				break;
			case "back":
				System.out.println("");
				System.out.println("|--------------------------------|");
				System.out.println("| Going back to starting menu... |");
				System.out.println("|--------------------------------|");
				System.out.println("");
				stopLoop = true;
				break;
			default:
				System.out.println("");
				System.out.println("|-------------------|");
				System.out.println("| No such choice... |");
				System.out.println("|-------------------|");
				System.out.println("");
			}
			if (stopLoop) break;
		}
	}

	
}