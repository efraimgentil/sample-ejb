package me.efraimgentil.sampleejbwar.view;

import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import me.efraimgentil.sampleejb.core.KnownEJBS;
import me.efraimgentil.sampleejb.core.model.User;
import me.efraimgentil.sampleejb.core.service.ApplicationMapperServiceRemote;

@Named
@RequestScoped
public class ApplicationMapperrRemoteCallerMB {
	
	
	@EJB(lookup = KnownEJBS.ApplicationMapperServiceRemote)
	ApplicationMapperServiceRemote service;
	
	private String key;
	private String value;
	
	
	public static void main(String[] args) {
//		String num = "mmmmm";
//		
//		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
//	    ht.put('i',1);
//	    ht.put('x',10);
//	    ht.put('c',100);
//	    ht.put('m',1000);
//	    ht.put('v',5);
//	    ht.put('l',50);
//	    ht.put('d',500);
//		
//	    int intNum=0;
//	    int prev = 0;
//	    for(int i = num.length()-1; i>=0 ; i--)
//	    {
//	            int temp = ht.get(num.charAt(i));
//	            if(temp < prev)
//	                intNum-=temp;
//	            else
//	                intNum+=temp;
//	            prev = temp;
//	    }
//	    System.out.println( intNum );
//		int a = 1;
//		int b = 2;
//		
//		int c = a & b;
//		System.out.println( 1 & 2 );
//		System.out.println( 1 & 3 );
//		System.out.println( 1 & 4 );

		String string = "saveCountTes";
		Pattern compile = Pattern.compile( "(?<=[a-z])([A-Z])(?=[a-z])");
		Matcher matcher = compile.matcher( string );
		System.out.println( matcher.groupCount() );
		while( matcher.find() ){
			System.out.println( matcher.group() );
		}
	}
	
	public User getUser(){
		return service.getValue("someKey", User.class);
	}
	
	public void putInCache(){
		service.putValue(key, value);
		key = null;
		value = null;
		String msg = "Valor adicionado com sucesso";
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage( FacesMessage.SEVERITY_INFO, msg  , msg ) );
	}
	
	public ApplicationMapperServiceRemote getService(){
		return service;
	}
	
	public List<String> getKeys(){
		return service.getKeys();
	}
	
	public Object getValue(String key){
		return service.getValue(key);
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
