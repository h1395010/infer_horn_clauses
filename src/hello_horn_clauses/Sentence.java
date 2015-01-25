package hello_horn_clauses;

import java.util.Objects;

public class Sentence 
{
	private String verb;
	private String object;
	private String subject;
	public Sentence(String verb, String object, String subject )
	{
		this.verb = verb;
		this.object = object;
		this.subject = subject;
	}
	
	public String getVerb()
	{
		return verb; 
	}
	
	public String getObject()
	{
		return object; 
	}
			
	public String getSubject()
	{
		return subject;
	}
	
	public String toString()
	{
		return verb + "(" + object + ", " + subject + ").";
	}
	
	@Override
	public boolean equals(Object other)
	{
	    if (!(other instanceof Sentence))
	        return false;
	    if (other == this)
	        return true;
	    Sentence o = (Sentence) other;
	    return o.subject.equals(subject) && o.object.equals(object) && o.verb.equals(verb);
	}
	
	@Override
	public int hashCode ()
	{
	    return Objects.hash(object, subject, verb);
	}
	
	
	
	
}


