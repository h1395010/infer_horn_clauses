package hello_horn_clauses;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ontology 
{
	private List<Sentence> sentences = new ArrayList<>();
	
	private Map<String,List<Integer>> subject2index = new HashMap<>();
	
	private Map<String,List<Integer>> object2index = new HashMap<>();
	
	private Set<String> joints = new HashSet<>();
	
	public void addSentence( Sentence s )
	{
		sentences.add( s );
		
		List<Integer> subind = subject2index.get( s.getSubject() );
		
		if( subind == null )
		{
			subind = new ArrayList<>();
			subject2index.put( s.getSubject(), subind );
		}
		
		subind.add( sentences.size() - 1 );
		
		List<Integer> objind = object2index.get( s.getObject() );
		
		if( objind == null )
		{
			objind = new ArrayList<>();
			object2index.put( s.getObject(), objind );
		}
		
		objind.add( sentences.size() - 1 );
		
		if( subject2index.containsKey( s.getObject() ) )
		{
			joints.add( s.getObject() );
		}
		
		if( object2index.containsKey( s.getSubject() ) )
		{
			joints.add( s.getSubject() );
		}
	}
	
	public Collection<String> getJoints()
	{
		return joints;
	}
	
	public List<Integer> getSubjectIndices( String subject )
	{
		return subject2index.get( subject );
	}
	
	public List<Integer> getObjectIndices( String object )
	{
		return object2index.get( object );
	}
	
	public Sentence getSentence( int index )
	{
		return sentences.get( index );
	}
}
