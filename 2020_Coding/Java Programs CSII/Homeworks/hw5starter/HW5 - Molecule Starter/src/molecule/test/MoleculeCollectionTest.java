// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: Google was used for the verification of Hydrocarbons.

package molecule.test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import molecule.*;

import org.junit.Test;

public class MoleculeCollectionTest
{	
	@Test
	public void testAddMoleculeValid()
	{
		Molecule m0 = new Molecule("(CH3CH2)3CCH(CH2CH3)2");
		Molecule m1 = new Molecule("H2");
		Molecule m2 = new Molecule("O2");
		Molecule m3 = new Molecule("CO2");
		Molecule m4 = new Molecule("H2O");
		Molecule m5 = new Molecule("H2O2");
		Molecule m6 = new Molecule("C6H6");
		Molecule m7 = new Molecule("C6H12O6");
		Molecule m8 = new Molecule("C12H22O11");
		Molecule m9 = new Molecule("(C8H8)2");
		Molecule m10 = new Molecule("CH3(CH2)6CH3");

		int[] w = {170, 2, 32, 44, 18, 24, 78, 180, 342, 208, 114};

		LinkedList<Molecule> d1 = new LinkedList<Molecule>();
		d1.add(m0);
		d1.add(m1);
		d1.add(m2);
		d1.add(m3);

		MoleculeCollection c0 = new MoleculeCollection(d1);
		assertEquals(c0.moleculeWeights(), w[0] + w[1] + w[2] + w[3]);

		MoleculeCollection c1 = new MoleculeCollection();
		c1.addMolecule(0, m0);
		assertEquals(c1.moleculeWeights(), w[0]);
		c1.addMolecule(1, m1);
		assertEquals(c1.moleculeWeights(), w[0] + w[1]);
	}
	
	@Test
	public void testAddMoleculeInvalid()
	{
		Molecule b1 = null;
		
		Molecule t1 = new Molecule("H2O");
		LinkedList<Molecule> d1 = new LinkedList<Molecule>();
		d1.add(t1);
		d1.add(b1);
		
		MoleculeCollection c0 = new MoleculeCollection(d1);
		assertEquals(c0.moleculeWeights(), 18);
	}
	
	
	
	
	@Test
	public void testSort()
	{
		Molecule m0 = new Molecule("(CH3CH2)3CCH(CH2CH3)2");
		Molecule m1 = new Molecule("H2");
		Molecule m2 = new Molecule("O2");
		Molecule m3 = new Molecule("CO2");
		Molecule m4 = new Molecule("H2O");
		Molecule m5 = new Molecule("H2O2");
		Molecule m6 = new Molecule("C6H6");
		Molecule m7 = new Molecule("C6H12O6");
		Molecule m8 = new Molecule("C12H22O11");
		Molecule m9 = new Molecule("(C8H8)2");
		Molecule m10 = new Molecule("CH3(CH2)6CH3");

		int[] w =
		{
			170, 2, 32, 44, 18, 24, 78, 180, 342, 208, 114
		};

		LinkedList<Molecule> d1 = new LinkedList<Molecule>();
		d1.add(m3);
		d1.add(m0);
		d1.add(m1);
		d1.add(m2);
		 
		MoleculeCollection c0 = new MoleculeCollection(d1);
		c0.sort();
		LinkedList<Molecule> s1 = new LinkedList<Molecule>();
		s1.add(m1);
		s1.add(m2);
		s1.add(m3);
		s1.add(m0);

		assertEquals(s1.toString(), c0.getMoleculeList().toString());
	}
	
	@Test
	public void testMoleculeWeights()
	{
		Molecule m0 = new Molecule("(CH3CH2)3CCH(CH2CH3)2");
		Molecule m1 = new Molecule("H2");
		Molecule m2 = new Molecule("O2");
		Molecule m3 = new Molecule("CO2");
		Molecule m4 = new Molecule("H2O");
		Molecule m5 = new Molecule("H2O2");
		Molecule m6 = new Molecule("C6H6");
		Molecule m7 = new Molecule("C6H12O6");
		Molecule m8 = new Molecule("C12H22O11");
		Molecule m9 = new Molecule("(C8H8)2");
		Molecule m10 = new Molecule("CH3(CH2)6CH3");

		int[] w = {170, 2, 32, 44, 18, 34, 78, 180, 342, 208, 114};
		LinkedList<Molecule> d1 = new LinkedList<Molecule>();
		d1.add(m0);
		d1.add(m1);
		d1.add(m2);
		d1.add(m3);
		d1.add(m4);
		d1.add(m5);
		d1.add(m6);
		d1.add(m7);
		d1.add(m8);
		d1.add(m9);
		d1.add(m10);
		int sum = 0;
		for (int i = 0; i < w.length; i++)
		{
			sum += w[i];
		}
		MoleculeCollection c1 = new MoleculeCollection(d1);
		assertEquals(sum, c1.moleculeWeights());
		MoleculeCollection c2 = new MoleculeCollection();
		assertEquals(0, c2.moleculeWeights());
	}
	
	@Test
	public void testChangeSequenceValid()
	{
		Molecule m1 = new Molecule("H2");
		Molecule m2 = new Molecule("O2");
		Molecule m3 = new Molecule("CO2");
		
		Molecule m5 = new Molecule("H2O2");
		
		LinkedList<Molecule> d1 = new LinkedList<Molecule>();
		d1.add(m1);
		d1.add(m2);
		d1.add(m3);
		MoleculeCollection c1 = new MoleculeCollection(d1);
		c1.changeSequence(1, "H2O2");
		LinkedList<Molecule> d2 = new LinkedList<Molecule>();
		d2.add(m1);
		d2.add(m5);
		d2.add(m3);
		assertEquals(d2.toString(), c1.getMoleculeList().toString());
	}
	
	@Test
	public void testChangeSequenceInvalid()
	{
		Molecule m1 = new Molecule("H2");
		Molecule m2 = new Molecule("O2");
		Molecule m3 = new Molecule("CO2");
		
		Molecule m5 = new Molecule("H2O2");
		
		LinkedList<Molecule> d1 = new LinkedList<Molecule>();
		d1.add(m1);
		d1.add(m2);
		d1.add(m3);
		MoleculeCollection c1 = new MoleculeCollection(d1);
		c1.changeSequence(10000, "H2O2");
		assertEquals(d1.toString(), c1.getMoleculeList().toString());
	}

}
