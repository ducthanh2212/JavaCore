package test.model;

import lombok.Data;

@Data
public class Film extends Movie{

	private Gener gener;
	
	public Film(String title, int like, Gener gener) {
		super(title, like);
		this.gener = gener;
	}

	@Override
	public String toString() {
		
		return super.toString()+", " + "gener: "+gener+"}";
	}

	
	
}
