package hello_horn_clauses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lets_go 
{
	
	
	public static void main(String[] args) throws IOException 
	{
	    Ontology ontology = new Ontology();
	    BufferedReader br = new BufferedReader(new FileReader("/home/matthias/Workbench/SUTD/2_January/Prolog/horn_data_test.pl"));
	    Pattern p = Pattern.compile("'(.*?)'\\('(.*?)','(.*?)'\\)\\."); 
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
	                System.out.println( s );
	            }
	        }
	    }
	}	
}
	









/*	
	
	public static void main(String[] args) throws IOException
    {	
		
		BufferedReader br_0 = new BufferedReader(new FileReader("/home/matthias/Workbench/SUTD/2_January/Prolog/horn_data_test.pl"));
		String line_0;
		
		
		List<List<String>> arr = new ArrayList<>();
		Pattern p = Pattern.compile("'(.*?)'(?![a-zA-Z])"); 
		//while the file is still reading
		while ((line_0 = br_0.readLine()) != null) {
		     List<String> three = new ArrayList<>();         
		     Matcher m = p.matcher(line_0);
		     int j = 0;
		     while (m.find()) {
		         three.add( m.group(1) );
		     }
		     arr.add( three );
		}

		br_0.close();
		
		
		
		for( List<String> three: arr ){
		    for( String s: three ){
		        System.out.print( s  + " |||" );
		    }
		    System.out.println();
		}
		
		    
		 
		

		
		
		
		
		
		
		
		
		
		
		 
		    
		    
	 }
		
    
	
}












Map<String,Integer> occurs = new HashMap<>();
int i = 0;
for( List<String> three: arr ){
    for( String s: three ){
        Integer where = occurs.get( s );
        if( where == null ){
            occurs.put( s, i );
        } else {
            System.out.println( s + " already in " + where +
                                " and also in " + i );
        }
    }
    i++;
}
*/

	