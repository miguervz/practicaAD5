package practica5AD;

import static com.mongodb.client.model.Filters.eq;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.DeleteOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class Metodos {
	public static MongoClient conexion = MongoClients.create("mongodb://localhost:27017");
	 public static MongoDatabase database = conexion.getDatabase("ADP5");
public static 	MongoCollection<Document> harrypotter = database.getCollection("harry-potter");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		eliminarDocumentos();
	}
public static  void insertarDocumentos(){
	
	Document documento = new Document("name", "Manolo").append("species", "human").append("gender", "male").append("house", "Gryffindor").append("dateOfBirth", "25-5-1997").append("yearOfBirth", 1997).append("ancestry", "").append("eyeColour", "brown").append("patronus", "camel").append("hogwartsStudent", true).append("hogwartsStaff", false).append("actor", "Miguel Ramírez").append("alive", true);

	/* Añadimos un único documento */
	harrypotter.insertOne(documento);

		
	}
public static  void consultarHumanos(){
	FindIterable<Document> humanos = harrypotter.find(eq("species", "human"));
	for (Object harrypotter : humanos) {
		System.out.println(((Document) harrypotter).toJson());
	}}
public static  void consultarAntesDe1979(){
	FindIterable<Document> antes1979 = harrypotter.find(lte("yearOfBirth", 1978));
	for (Object harrypotter : antes1979) {
		System.out.println(((Document) harrypotter).toJson());
	}}
public static  void consultarVaritaSagrada(){
	FindIterable<Document> varitaSagrada = harrypotter.find(eq("wand.wood", "holly"));
	for (Object harrypotter : varitaSagrada) {
		System.out.println(((Document) harrypotter).toJson());
	}}
public static  void consultarEstudiantesVivos(){
	FindIterable<Document> estudiantesVivos = harrypotter.find(and(eq("alive", true), eq("hogwartsStudent", true)));
	for (Object harrypotter : estudiantesVivos) {
		System.out.println(((Document) harrypotter).toJson());
	}}

public static  void actualizarDocumentos(){
	try{
	harrypotter.updateOne(eq("name", "Manolo"), combine(set("name", "Gobernador")));
	}
	catch (ClassCastException e) {
		
		e.printStackTrace();
	}
	}
public static  void eliminarDocumentos(){
	try{
	harrypotter.deleteOne(eq("name", "Gobernador") );
	}
	catch (ClassCastException e) {
		
		e.printStackTrace();
	}
	}

}
