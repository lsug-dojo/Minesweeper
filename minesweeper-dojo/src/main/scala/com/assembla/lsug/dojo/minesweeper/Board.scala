package com.assembla.lsug.dojo.minesweeper

object Board {
	type Grid = List[List[Int]]
	def transform(s:String) = {
		"*100\n2210\n1*10\n1110"

	}

	def parse(in: String): Grid = {
		def parseRow(row: String) = {
			row.map {
				case '*' => 1
				case _   => 0
			} toList
		}
		in.split('\n').map(parseRow _).toList
	}
}