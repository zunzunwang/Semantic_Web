package semweb;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.semarglproject.jena.rdf.rdfa.JenaRdfaReader;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

public class Session5 {

	public static void main(String[] args) {
		JenaRdfaReader.inject();
		Model m = ModelFactory.createDefaultModel();		
		String w3cstaff= "http://www.emse.fr/~zimmermann/Teaching/SemWeb/w3cstaff.html";
		/*
		String ex = "http://example.com/";
		String rdfs = "http://www.w3.org/2000/01/rdf-schema#";
		String geo = "http://www.w3.org/2003/01/geo/wgs84_pos#";
		String xsd = "http://www.w3.org/2001/XMLSchema#";
		*/
		String v = "http://www.emse.fr/~zimmermann/Teaching/SemWeb/vocab.ttl#";
//		String Scientist ="http://www.emse.fr/~zimmermann/Teaching/SemWeb/vocab.ttl#Scientist";
		m.read(w3cstaff,"RDFA");
		m.write(System.out);
	/*	
		m.setNsPrefix("ex", ex);
		m.setNsPrefix("rdfs", rdfs);
		m.setNsPrefix("geo", geo);
		m.setNsPrefix("xsd", xsd);
		*/
		m.setNsPrefix("v", v);	
		Resource Scientist = m.createResource(v + "Scientist");
		
		// select all the resources with a VCARD.FN property
		ResIterator iter = m.listSubjectsWithProperty(RDF.type);
		if (iter.hasNext()) {
			System.out.println("The model contains those rdf:type :");
			 while (iter.hasNext()) {
				 //if(iter.nextResource().getPropertyResourceValue(RDF.type)==(Scientist))
				 System.out.println("  " + iter.nextResource().getPropertyResourceValue(RDF.type));
		
			 }			
		}else {
            System.out.println("No rdf:type were found in the model");
        } 
		
		Map<String, String> prefixMap = m.getNsPrefixMap();
		System.out.println(prefixMap.values());
		 



}
}