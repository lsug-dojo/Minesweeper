package com.assembla.lsug.dojo.minesweeper

import org.junit.Assert.assertThat
import org.hamcrest.CoreMatchers._
import org.junit.{Ignore, Test}
import java.lang.String

class BoardReaderTest {

  val oneLineInput: String = "*.."

  val input = """|*...
	    			     |....
					       |.*..
					       |....""" stripMargin

	val expectedBoard = """|*100
							   |2210
							   |1*10
							   |1110""" stripMargin

	@Test
	def testThatWeCanCreateABoardDesign() {

		val output = Board.transform(input)
    assertThat( output.count( _ == '\n' ), is(3))
		assertThat( output, is(equalTo (expectedBoard)))
	}

  @Test
  def testGetNeighbourCells() {
    val board = Board.parse(input)

    var cornerCells:Seq[Cell] = Board.getNeighbourCells(board, 0,0);
    assertThat(cornerCells.length, is(3));
    cornerCells = Board.getNeighbourCells(board, 0,3);
    assertThat(cornerCells.length, is(3));
    cornerCells = Board.getNeighbourCells(board, 3,0);
    assertThat(cornerCells.length, is(3));
    cornerCells = Board.getNeighbourCells(board, 0,3);
    assertThat(cornerCells.length, is(3));
    val middleCells:Seq[Cell] = Board.getNeighbourCells(board, 2,2);
    assertThat(middleCells.length, is(8));

  }

  @Test
  def testUpdateNeighbours(){
     val output = Board.parse(oneLineInput)
     val outputCells = Board.updateNeighbours(output)
                         assertThat(outputCells.size, is(equalTo(1)))
    outputCells.map(row => {
         assertThat(row.size, is(equalTo(3)))
    })

     val expected: Board.Grid = Array(Array(Cell(true, None), Cell(false, Some(1)), Cell(false, Some(0)))) 
     assertThat(output, is(equalTo(expected)))
  }

	@Test
  @Ignore
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
    val expectedGrid:Array[Array[Cell]]  = Array(Array(Cell(true),Cell(false),Cell(false)))

    val b = Board.parse(oneLineInput)
		// assertThat(b.length, is(equalTo (1)))

    assertThat(b, is(equalTo (expectedGrid)))
	}

  @Test
  def test2LiveGridParsing() {

    val expectedGrid = Array(Array(Cell(true),Cell(false),Cell(false)),
                             Array(Cell(false),Cell(true),Cell(true)))
    val twoLines = "*..\n.**"

    val b = Board.parse(twoLines)

    assertThat(b, is(expectedGrid))
  }

/*  The following tests have been commented out as they represent how something can be coded
    and not the intent of the tests.  It is recommnended that the following tests be written
    in a similar approach to the above test in the next dojo.
*/

//	@Test
//	def testParseTwoRows() {
//		assertThat(Board.parse("*..\n..."), is(equalTo (List(List(1, 0, 0), List(0, 0, 0)))))
// 	}
//
//	@Test
//	def testEmptyRow {
//		val emptyRow = "...."
//		assertThat(Board.parse(emptyRow), is(equalTo(List(List(0, 0, 0, 0)))))
//	}
//
//	@Test
//	def testEmptyString {
//		val emptyString = ""
//		assertThat(Board.parse(emptyString), is(equalTo(List(List[Int]()))))
//	}
//
//  @Test
//  def testTransformOfOneLine() {
//    assertThat(Board.transform("..*."), is(equalTo("01*1")))
//  }
//
//  @Test
//  def testACellShouldSayItIsAMine() {
//    assertThat(new Cell(true).isMine, is(true))
//  }
}