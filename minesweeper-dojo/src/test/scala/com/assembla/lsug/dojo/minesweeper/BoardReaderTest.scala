package com.assembla.lsug.dojo.minesweeper

import org.junit.Test
import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._

class BoardReaderTest {

	@Test
	def testThatWeCanCreateABoardDesign() {
	    val input = """|*...
	    			   |....
					   |.*..
					   |....""" stripMargin

		val expectedBoard = """|*100
							   |2210
							   |1*10
							   |1110""" stripMargin

		val output = Board.transform(input)
		assertThat( output, is(equalTo (expectedBoard)))
	}
	@Test
	def	testEmptyField(){

		val input = """|....
					   |....
					   |....
					   |....""" stripMargin

		val expectedBoard = """|0000
							   |0000
							   |0000
							   |0000""" stripMargin

		val output = Board.transform(input)
		assertThat( output, is(equalTo (expectedBoard)))
	}

	@Test
	def testParsing() {
		assertThat(Board.parse("*.."), is(equalTo (List(List(1, 0, 0)))))
	}

	@Test
	def testParseTwoRows() {
		assertThat(Board.parse("*..\n..."), is(equalTo (List(List(1, 0, 0), List(0, 0, 0)))))
 	}

	@Test
	def testEmptyRow {
		val emptyRow = "...."
		assertThat(Board.parse(emptyRow), is(equalTo(List(List(0, 0, 0, 0)))))
	}

	@Test
	def testEmptyString {
		val emptyString = ""
		assertThat(Board.parse(emptyString), is(equalTo(List(List[Int]()))))
	}
}