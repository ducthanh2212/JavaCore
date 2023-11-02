package test;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ShareData {
	public int rad = 0;
	
	public List<Integer> lstNum = new ArrayList<>();
	
	public List<Character> lstChar = new ArrayList<>();
}
