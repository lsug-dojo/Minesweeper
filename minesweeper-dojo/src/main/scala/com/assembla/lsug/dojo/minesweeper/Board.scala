package com.assembla.lsug.dojo.minesweeper

object Board {
	type Grid = List[List[Cell]]
	def transform(s:String) : String = {

   // val outputString = new scala.collection.mutable.ListBuffer[String]
    val grid = parse(s)
//    val listOfInt: List[Int] = grid flatMap
    
    val slots: List[String] = for {row <- grid } yield codeFor(row)

    slots reduceLeft({_+_})
/*     grid.foreach(row => {
      row.foreach(slot =>
        outputString += codeFor(slot))              (({new Cell(tru{new Cell(tru
    })
    outputString.reduce("", {_+_})
*/
    //outputString
	}

  def updateNeighbours(grid: Grid): Grid = {
    val cells = scala.collection.mutable.ListBuffer[Cell]()

    grid.iterator.next.iterator.sliding(3).map(processCell(_))
  }
  def processCell(cells : (Cell, Cell, Cell)) {
      new Cell (cells._2.isMine, if (!cells._2.isMine) 
        Some(List(cells._1.isMine, cells._3.isMine).count(_))
        else None)
  }

  def codeFor(row : List[Cell]):String = row match {
    case cell::rest if cell.isMine => "*" + codeFor(rest)
    case _::rest => "0" + codeFor(rest)
    case _  => ""
  }

	def parse(in: String): Grid = {
		def parseRow(row: String) = {
			row.map {
				case '*' => new Cell(true)
				case _   => new Cell(false)
			} toList
		}
		in.split('\n').map(parseRow _).toList
	}

}


case class Cell(val isMine: Boolean, val hint: Option[Int] = None) {

}