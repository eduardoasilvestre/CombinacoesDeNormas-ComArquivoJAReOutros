package testecombinatoricslib;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*		   ICombinatoricsVector<String> initialVector = Factory.createVector(
	      new String[] { "red", "black", "white", "green", "blue" } );

	   Generator<String> gen = Factory.createSimpleCombinationGenerator(initialVector, 3);

	   for (ICombinatoricsVector<String> combination : gen) {
	      System.out.println(combination);
	   }*/
		
		   /*ICombinatoricsVector<String> initialVector = Factory.createVector(
		   new String[] { "red", "black", "white" } );

			Generator<String> gen = Factory.createSimpleCombinationGenerator(initialVector, 2);
			
			
			
			
			for (ICombinatoricsVector<String> combination : gen) {
				   List<String> string = combination.getVector();
				   System.out.println(string);
			}*/
		
		

		List<Norm> norms = buildSomeNorms();
		int tamanho = norms.size();
		int totalDeCombinacoes = 0;
		
		for (int i = 2; i <= tamanho; i++) {
			System.out.println("Análise será feita com  o seguinte número de normas: " + i);
			ICombinatoricsVector<Norm> initialVector = Factory.createVector(norms);
			   
			Generator<Norm> gen = Factory.createSimpleCombinationGenerator(initialVector, i);
			totalDeCombinacoes += gen.getNumberOfGeneratedObjects();
			
			for (ICombinatoricsVector<Norm> combination : gen) {
				List<Norm> r = combination.getVector();
				
				for (Norm n: r) {
					System.out.print(n.getContador());
				}
				System.out.println();
			}
			
		}
		System.out.println("O total de combinações geradas foi: " + totalDeCombinacoes);
	}

	
	 private static List<Norm> buildSomeNorms() {
			List<Norm> normSet = new ArrayList<>();
			
			//n1 and n2 are in conflict: OBLIGATION X PROHIBITION
			Context context1 = new Context("university", ContextType.ORGANIZATION);
			Entity entity1 = new Entity ("student", EntityType.ROLE);
			Behavior action1 = new BehaviorAtomicAction("study");
			Constraint aConstraint1 = null; 
			Constraint dConstraint1 = null; 
			Norm norm1 = new Norm(DeonticConcept.OBLIGATION, context1, entity1, action1, aConstraint1, dConstraint1, State.NONE);
			norm1.setContador(1);
			normSet.add(norm1);
			
			//n2 and n3 are in conflict: PROHIBITION X PERMISSION
			Context context2 = new Context("university", ContextType.ORGANIZATION);
			Entity entity2 = new Entity ("student", EntityType.ROLE);
			Behavior action2 = new BehaviorAtomicAction("study");
			Constraint aConstraint2 = null; 
			Constraint dConstraint2 = null; 
			Norm norm2 = new Norm(DeonticConcept.PROHIBITION, context2, entity2, action2, aConstraint2, dConstraint2, State.NONE);
			norm2.setContador(2);
			normSet.add(norm2);
			
			Context context3 = new Context("university", ContextType.ORGANIZATION);
			Entity entity3 = new Entity ("student", EntityType.ROLE);
			Behavior action3 = new BehaviorAtomicAction("study");
			Constraint aConstraint3 = null; 
			Constraint dConstraint3 = null; 
			Norm norm3 = new Norm(DeonticConcept.PERMISSION, context3, entity3, action3, aConstraint3, dConstraint3, State.NONE);
			norm3.setContador(3);
			normSet.add(norm3);
			
			//n4 is not in conflict (with n1, n2 or n3) because the norm is FULFILLED (could be VIOLATED)
			Context context4 = new Context("university", ContextType.ORGANIZATION);
			Entity entity4 = new Entity ("student", EntityType.ROLE);
			Behavior action4 = new BehaviorAtomicAction("study");
			Constraint aConstraint4 = null;
			Constraint dConstraint4 = null;
			Norm norm4 = new Norm(DeonticConcept.PROHIBITION, context4, entity4, action4, aConstraint4, dConstraint4, State.NONE);
			norm4.setContador(4);
			normSet.add(norm4);
			
			
			//n5 x n2: ther is not a conflict because the actions are differente. How to solve ?????????
			Context context5 = new Context("university", ContextType.ORGANIZATION);
			Entity entity5 = new Entity ("student", EntityType.ROLE);
			Behavior action5 = new BehaviorAtomicAction("have lunch");
			Constraint aConstraint5 = null; 
			Constraint dConstraint5 = null; 
			Norm norm5 = new Norm(DeonticConcept.OBLIGATION, context5, entity5, action5, aConstraint5, dConstraint5, State.NONE);
			norm5.setContador(5);
			normSet.add(norm5);
			
			//n6 x n7: there is no conflict. Different entities
			Context context6 = new Context("team", ContextType.ORGANIZATION);
			Entity entity6 = new Entity ("player", EntityType.ROLE);
			Behavior action6 = new BehaviorAtomicAction("play");
			Constraint aConstraint6 = null; 
			Constraint dConstraint6 = null; 
			//State state6 = null;
			Norm norm6 = new Norm(DeonticConcept.PROHIBITION, context6, entity6, action6, aConstraint6, dConstraint6, State.FULFILLED);
			norm6.setContador(6);
			normSet.add(norm6);
			
			Context context7 = new Context("team", ContextType.ORGANIZATION);
			Entity entity7 = new Entity ("manager", EntityType.ROLE);
			Behavior action7 = new BehaviorAtomicAction("play");
			Constraint aConstraint7 = null; 
			Constraint dConstraint7 = null; 
			Norm norm7 = new Norm(DeonticConcept.PROHIBITION, context7, entity7, action7, aConstraint7, dConstraint7, State.NONE);
			norm7.setContador(7);
			normSet.add(norm7);
			
			//norm8 and norm9 different contexts
			Context context8 = new Context("team", ContextType.ENVIRONMENT);
			Entity entity8 = new Entity ("manager", EntityType.ROLE);
			Behavior action8 = new BehaviorAtomicAction("manage");
			Constraint aConstraint8 = null; 
			Constraint dConstraint8 = null; 
			Norm norm8 = new Norm(DeonticConcept.PERMISSION, context8, entity8, action8, aConstraint8, dConstraint8, State.NONE);
			norm8.setContador(8);
			normSet.add(norm8);
			
			Context context9 = new Context("company", ContextType.ORGANIZATION);
			Entity entity9 = new Entity ("manager", EntityType.ROLE);
			Behavior action9 = new BehaviorAtomicAction("manage");
			Constraint aConstraint9 = null; 
			Constraint dConstraint9 = null; 
			Norm norm9 = new Norm(DeonticConcept.PROHIBITION, context9, entity9, action9, aConstraint9, dConstraint9, State.NONE);
			norm9.setContador(9);
			normSet.add(norm9);
			
			//n10 and n11: is not in conflict due the different action
			Context context10 = new Context("company", ContextType.ORGANIZATION);
			Entity entity10 = new Entity ("manager", EntityType.ROLE);
			Behavior action10 = new BehaviorAtomicAction("manage");
			Constraint aConstraint10 = null; 
			Constraint dConstraint10 = null; 
			Norm norm10 = new Norm(DeonticConcept.PROHIBITION, context10, entity10, action10, aConstraint10, dConstraint10, State.NONE);
			normSet.add(norm10);
			/*
			
			Context context11 = new Context("company", ContextType.ORGANIZATION);
			Entity entity11 = new Entity ("manager", EntityType.ROLE);
			Behavior action11 = new BehaviorAtomicAction("manage");
			Constraint aConstraint11 = null; 
			Constraint dConstraint11 = null; 
			Norm norm11 = new Norm(DeonticConcept.PROHIBITION, context11, entity11, action11, aConstraint11, dConstraint11, State.NONE);
			normSet.add(norm11);

			//norm11 and norm12 are not in conflict because norm12 is violated
			Context context12 = new Context("company", ContextType.ORGANIZATION);
			Entity entity12 = new Entity ("manager", EntityType.ROLE);
			Behavior action12 = new BehaviorAtomicAction("manage");
			Constraint aConstraint12 = null; 
			Constraint dConstraint12 = null; 
			Norm norm12 = new Norm(DeonticConcept.PERMISSION, context12, entity12, action12, aConstraint12, dConstraint12, State.VIOLATED);
			normSet.add(norm12);
			
			
			// norm13, norm14 and norm 15 consider time
			//norm13 x norm14: there is not conflict
			//norm14 x norm15: there is conflict
			Context context13 = new Context("home", ContextType.ORGANIZATION);
			Entity entity13 = new Entity ("mother", EntityType.ROLE);
			Behavior action13 = new BehaviorAtomicAction("cook");
			Constraint aConstraint13 = new ConstraintDate(ConstraintType.DATETYPE, buildDateTime("18/07/2014"));
			Constraint dConstraint13 = new ConstraintDate(ConstraintType.DATETYPE, buildDateTime("20/07/2014"));
			Norm norm13 = new Norm(DeonticConcept.OBLIGATION, context13, entity13, action13, aConstraint13, dConstraint13, State.NONE);
			normSet.add(norm13);
			
			Context context14 = new Context("home", ContextType.ORGANIZATION);
			Entity entity14 = new Entity ("mother", EntityType.ROLE);
			Behavior action14 = new BehaviorAtomicAction("cook");
			Constraint aConstraint14 = new ConstraintDate(ConstraintType.DATETYPE, buildDateTime("15/07/2014"));
			Constraint dConstraint14 = new ConstraintDate(ConstraintType.DATETYPE, buildDateTime("17/07/2014"));
			Norm norm14 = new Norm(DeonticConcept.PROHIBITION, context14, entity14, action14, aConstraint14, dConstraint14, State.NONE);
			normSet.add(norm14);
			
			
			Context context15 = new Context("home", ContextType.ORGANIZATION);
			Entity entity15 = new Entity ("mother", EntityType.ROLE);
			Behavior action15 = new BehaviorAtomicAction("cook");
			Constraint aConstraint15 = new ConstraintDate(ConstraintType.DATETYPE, buildDateTime("19/07/2014"));
			Constraint dConstraint15 = new ConstraintDate(ConstraintType.DATETYPE, buildDateTime("20/07/2014"));
			Norm norm15 = new Norm(DeonticConcept.PROHIBITION, context15, entity15, action15, aConstraint15, dConstraint15, State.NONE);
			normSet.add(norm15);
			
			Context context16 = new Context("home", ContextType.ORGANIZATION);
			Entity entity16 = new Entity ("mother", EntityType.ROLE);
			Behavior action16 = new BehaviorAtomicAction("dress");
			Constraint aConstraint16 = new ConstraintDate(ConstraintType.DATETYPE, buildDateTime("19/07/2014"));
			Constraint dConstraint16 = new ConstraintDate(ConstraintType.DATETYPE, buildDateTime("20/07/2014"));
			Norm norm16 = new Norm(DeonticConcept.PROHIBITION, context16, entity16, action16, aConstraint16, dConstraint16, State.NONE);
			normSet.add(norm16);
			
			Context context17 = new Context("home", ContextType.ORGANIZATION);
			Entity entity17 = new Entity ("mother", EntityType.ROLE);
			Behavior action17 = new BehaviorAtomicAction("dress");
			Constraint aConstraint17 = new ConstraintDate(ConstraintType.DATETYPE, buildDateTime("19/07/2014"));
			Constraint dConstraint17 = new ConstraintDate(ConstraintType.DATETYPE, buildDateTime("20/07/2014"));
			Norm norm17 = new Norm(DeonticConcept.PERMISSION, context17, entity17, action17, aConstraint17, dConstraint17, State.NONE);
			normSet.add(norm17);
			
			*/
			
			
			return normSet;
			
		}
	 

}
