package com.assembla.lsug.dojo.minesweeper

object Board {

  type Grid = Array[Array[Cell]]

  def transform(s:String) : String = {

    val grid = parse(s)

    val transformedGrid = updateNeighbours(grid);

    val slots: Array[String] = for {row <- grid } yield codeFor(row)

    slots reduceLeft({_+'\n'+_})
    

<<<<<<< HEAD
	}
  def updateNeighbours(grid: Grid): Grid = {

    //val newGrid = new scala.collection.mutable.ArrayList[new scala.collection.mutable.ArrayList]()

    for(row <- (0 to grid.length -1)) {
      for (col <- (0 to grid(row).length -1)) {
        val minesNearby = getNeighbourCells(grid, row, col).filter(_.isMine).length
        grid(row)(col) = Cell(grid(row)(col).isMine, if (grid(row)(col).isMine)  None else Some(minesNearby))

      }
    }
    grid
=======
  }

  def updateNeighbours(grid: Grid) = {grid}
  
  def getNeighbourCells(grid: Grid, row: Int, col: Int) : Seq[Cell] = {
    // TODO: This returns an Array[Array[Cell]] but we need Seq[Cell]
    /*
    grid.slice(row-1, row+1) map {
      _ slice(col-1, col+1)
    }
    */
    Seq(new Cell(false)) // Just to make it compile so
>>>>>>> cb2f24b506f2aaf787b41d452ca9caaf3f144ec4
  }


  def getNeighbourCells(grid: Grid,
                        row: Int,
                        col: Int): Seq[Cell] = {
    val offsets = List(-1, 0, 1)
    for (rowOffset <- offsets; colOffset <- offsets
         if rowOffset != 0 || colOffset != 0
      if rowOffset + row >= 0
      if colOffset + col >= 0
      if rowOffset + row < grid.length
      if colOffset + col < grid(0).length
      
    )
      yield grid(row + rowOffset)(col + colOffset)
  }


  def processCell(cells : (Cell, Cell, Cell)) = {
    null
  }

  def codeFor(row : Array[Cell]):String = {
    row.map{x => x.isMine match {
      case true => '*'
      case false => x.hint.get.toString
    }}.mkString("")
  }

  def parse(in: String): Grid = {
    def parseRow(row: String) = {
      row.map {
	case '*' => new Cell(true)
	case _   => new Cell(false)
      } toArray
    }
    in.split('\n').map(parseRow _).toArray
  }

}


case class Cell(val isMine: Boolean, val hint: Option[Int] = None) {

}
