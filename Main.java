import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {
	public static Stack<String> stk = new Stack<>();

	static Student[] enterStudent(Student std[]) {
		// stack define
		int num = std.length;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < num; i++) {
			std[i] = new Student();
			System.out.println("Enter Student Name");
			String studentName = sc.nextLine();
			std[i].setStName(studentName);
			stk.push(studentName);

			System.out.println("Enter Mark for Math");
			Integer m1 = sc.nextInt();
			String m = Integer.toString(m1);

			//int m1 = Integer.toString(m);
			stk.push(m);

			System.out.println("Enter Mark for English");
			// String e = sc.nextLine();
			Integer m2 = sc.nextInt();
			String e = Integer.toString(m2);
			// int m2 = Integer.parseInt(e);
			stk.push(e);

			Set<String> uniqueEmailSet = new HashSet<String>();
			ArrayList<String> emailArrayList = new ArrayList<>();

			System.out.println("Enter Email: ");
			String stuEmail = sc.next();
			stk.push(stuEmail);
			uniqueEmailSet.add(stuEmail);
			emailArrayList.add(stuEmail);

			Cours cours = new Cours();
			Mark mark = new Mark();

			School school = new School();
			Student student = new Student();

			student.setStName(studentName);
			mark.setMath(m1);
			mark.setEnglish(m2);
			cours.setMark(mark);
			std[i].setCours(cours);
			student.setCours(cours);
			school.setStudent(student);
			student.setStudentEmail(stuEmail);

			System.out.println("Student in School:" + student.getStName() + "\n" + "Math Mark is "
					+ student.getCours().getMark().getMath());
			System.out.println("Enghlish Mark is:" + student.getCours().getMark().getEnghlish());
		}

		return std;
	}

	static void printList(Student studentList[]) {
		for (int i = 0; i < studentList.length; i++) {
			System.out.println("Student name :" + studentList[i].getStName() + " " + "Math Mark is:"
					+ studentList[i].getCours().getMark().getMath());
			System.out.println("Enghlish Mark is:" + studentList[i].getCours().getMark().getEnghlish());
		}
	}

	static void Exit() {
		System.out.println("Exit");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isExit = true;

		System.out.println("Enter Number of Student you want:");
		Scanner sci = new Scanner(System.in);

		int num = sci.nextInt();
		Student std[] = new Student[num];

		
		Set<String> uniqueEmailSet = new HashSet<String>(); //Set doesn't accept duplicated values 
		ArrayList<String> emailArrayList = new ArrayList<>();
		
		
		double feesAmount = 0;
		double amountCal = 0;
		double amount;
		 
		 
		

		do {
			System.out.println("_______________________________________________");
			System.out.println("Select Option");
			System.out.println("1.Enter Student");
			System.out.println("2.Print List");
			System.out.println("3.show history");
			System.out.println("4.Email");
			System.out.println("5.Currency");
			System.out.println("6.Exit");
			int select = sc.nextInt();
			//int option = Integer.parseInt(select);

			switch (select) {
			case 1:
				std = enterStudent(std);
				break;

			case 2:
				printList(std);
				break;

			case 3:
				while (stk.empty() == false) {
					System.out.println("The history is : " + stk.pop());
				}
				break;

			case 4:
				Boolean x= true;
				while(x) {
				System.out.println("Enter Email: ");
				String stuEmail = sc.next();
				stk.push(stuEmail);
				emailArrayList.add(stuEmail);
				System.out.println("1 if you want cont, 0 if not");
				Integer d = sc.nextInt();
				if(d == 0) {
					x = false;
					
				}
				
				}

				for (String email : emailArrayList) {
					if (uniqueEmailSet.add(email) == false) {
						System.out.println("Duplicate this email" +" -->" + email);
					}	
				}
				break;

			case 5:
				Map<String, Double> currencyMap = new HashMap<>();
				Map<String, Map<String, Double>> comparisioMap = new HashMap<>();
				


				System.out.println("Enter student name who want to convert:");
				String studentConversiName = sc.next();
				stk.push(studentConversiName);
				System.out.println("Choose currency you want to convert" + "1. KUD" + "2. AED" + "3. USD");
				int currency = sc.nextInt();
				String m=Integer.toString(currency);
				stk.push(m);
				System.out.println("please insert fees amount");
				feesAmount = sc.nextDouble();
				String s1 = Double.toString(feesAmount);
				stk.push(s1);
				
				if(currency == 1) {
					amountCal= feesAmount *0.80;
					Math.round(amountCal);
					currencyName = "KUD";
				}
				else if(currency == 2) {
					amountCal= feesAmount *9.54;
					currencyName = "AED";
					
				}
				
				else if(currency == 3) {
					amountCal= feesAmount *2.60;
					currencyName = "USD";
					
				}
				
				currencyMap.put(currencyName, amountCal);
				comparisioMap.put(studentConversiName, currencyMap);
				System.out.println(currencyMap);
				System.out.println(comparisioMap);
				
				break;
				
			case 6:
				isExit = false;
				break;

			}
		}

		while (isExit);
	}
}