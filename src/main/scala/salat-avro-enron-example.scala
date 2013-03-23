/*
 * Copyright 2013 Julian Peeters
 *   
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import models._
import com.banno.salat.avro._
import global._
import java.io.File
import java.io._
import scala.io._
import org.apache.avro._
import org.apache.avro.io._
import org.apache.avro.file._
import org.apache.avro.generic._


object Main extends App {

//Deserialize from File: Read DataFile and deserialize back to object 
  val infile = new File("/home/julianpeeters/enron.avro")
  val bufferedInfile = scala.io.Source.fromFile(infile, "iso-8859-1")
  val parsable = bufferedInfile.getLine(0).dropWhile(_ != '{')

  val schema = Schema.parse(parsable) ////

  val datumReader = new GenericDatumReader[Any](schema)

  val dataFileReader = new DataFileReader(infile, datumReader)
  //val sameRecordIterator = grater[EnronEmail].asObjectIteratorFromDataFile(streamInfile)
  println(dataFileReader.next())

//TODO make sure no redundant imports, repos
//TODO finish this after adding asSchemaFromFile method to salat-avro

}
