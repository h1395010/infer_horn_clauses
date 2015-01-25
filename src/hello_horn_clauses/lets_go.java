package hello_horn_clauses;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Collections.reverseOrder;


public class lets_go 
{
	public static void main(String[] args) throws IOException 
	{
		
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("/home/matthias/Workbench/SUTD/2_January/learning_first-order_horn_clauses_from_web_text/reverb/code/input_data/output.txt"))));
		
		//reverb_e.input_7
		//reverb_original_data__sentences
		Ontology ontology = new Ontology();
	    BufferedReader br = new BufferedReader(new FileReader("/home/matthias/Workbench/SUTD/2_January/learning_first-order_horn_clauses_from_web_text/reverb/code/input_data/reverb_e.input_7.txt"));
	    Pattern p = Pattern.compile("'(.*?)'\\('(.*?)',\\s*'(.*?)'\\)\\.");
	    String line;
	    while ((line = br.readLine()) != null) 
	    {
	        Matcher m = p.matcher(line);
	        if( m.matches() ) 
	        {
	            String verb    = m.group(1);
	            String object  = m.group(2);
	            String subject = m.group(3);
	            ontology.addSentence( new Sentence( verb, object, subject ) );
	        }
	    }

	    for( String joint: ontology.getJoints() )
	    {
	    	for( Integer subind: ontology.getSubjectIndices( joint ) )
	        {
	        	Sentence xaS = ontology.getSentence( subind );

	        	for( Integer obind: ontology.getObjectIndices( joint ) )
	            {

	        		Sentence yOb = ontology.getSentence( obind );
	                
	                Sentence s = new Sentence( xaS.getVerb(),
	                                           xaS.getObject(),
	                                           yOb.getSubject() );
	                
	                //System.out.println( s );                
	                ontology.numberRules( s );    
	                
	            }
	        }
	    }
	    
	    
	    
	    
	    ontology.ruleCount.entrySet().stream()
	    //just some threshold
	    .filter(e -> e.getValue() > 333)
        .sorted(reverseOrder(Map.Entry.comparingByValue()))
        .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
	    
	    
	    
	    
	    
		
		
	}	
} 


	

	