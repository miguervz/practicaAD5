package practica5AD;

import static com.mongodb.client.model.Filters.eq;

import java.util.Arrays;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class Metodos {
	public static MongoClient conexion = MongoClients.create("mongodb://localhost:27017");
	 public static MongoDatabase database = conexion.getDatabase("ADP5");
public static 	MongoCollection<Document> harrypotter = database.getCollection("harry-potter");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
public static  void insertarDocumentos(){
	

	/* Añadimos varios documentos */
	harrypotter.insertMany(Arrays.asList(
			Document.parse("{name: 'Juana',species: 'Human',"
					+ "gender: 'female',house: 'Gryffindor',dateOfBirth: '01-10-1994',yearOfBirth:'1994',ancestry:'',"
					+ "eyeColour:'green',patronus:'turtle',hogwartsStudent:true,hogwartsStaff:false,alive:true,"
					+ "actor:'Isabel Gómez',wand: {wood: 'shadow',core: 'unicorn tail-hair',length:9}}"),
			Document.parse("{name: 'Julio',species: 'Human',gender: 'male',house: 'Slytherin',dateOfBirth: '25-1-1967',yearOfBirth:'1967',ancestry:'',"
					+ "eyeColour:'brown',patronus:'cow',hogwartsStudent:false,hogwartsStaff:false,alive:true,"
					+ "actor:'Nacho Vidal',wand: {wood: 'holly',core: 'unicorn horn',length:23}}")));
	}
public static  void insertarDocumento(){
	
	/* Añadimos un único documento */
	harrypotter.insertOne(
			Document.parse("{name: 'Manolo',species: 'Human',gender: 'male',house: 'Gryffindor',dateOfBirth: '25-5-1997',"
					+ "yearOfBirth:'1997',ancestry:'',eyeColour:'brown',patronus:'camel',hogwartsStudent:true,hogwartsStaff:false,"
					+ "alive:true,actor:'Miguel Ramírez',wand: {wood: 'holly',core: 'unicorn tail-hair',length:10}}"));
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
	harrypotter.updateOne(eq("name", "Manolo"), combine(set("name", "Alfredo"), set("house", "Slytherin")));
	}
	catch (ClassCastException e) {
		
		e.printStackTrace();
	}
	}
public static  void eliminarDocumentos(){
	try{
	harrypotter.deleteOne(eq("name", "Alfredo") );
	}
	catch (ClassCastException e) {
		
		e.printStackTrace();
	}
	}

}
