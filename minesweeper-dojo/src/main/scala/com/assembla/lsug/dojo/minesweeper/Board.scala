package com.assembla.lsug.dojo.minesweeper

object Board {

	type Grid = Array[Array[Cell]]

	def transform(s:String) : String = {

    val grid = parse(s)

    val transformedGrid = updateNeighbours(grid);

    val slots: Array[String] = for {row <- grid } yield codeFor(row)

    slots reduceLeft({_+'\n'+_})

	}
  def updateNeighbours(grid: Grid) = {grid}
  
  def getNeighbourCells(grid: Grid, row: Int, col: Int) : Seq[Cell] = {
    grid.slice(row-1, row+1) map {
      _ slice(col-1, col+1)
    }
  }

  def processCell(cells : (Cell, Cell, Cell)) = {
     null
  }

  def codeFor(row : Array[Cell]):String = {
    row.map(_.isMine match {
      case true => '*'
      case false => '0'
    }).mkString("")
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








