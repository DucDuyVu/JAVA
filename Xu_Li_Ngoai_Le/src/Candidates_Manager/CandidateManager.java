package Candidates_Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class CandidateManager {
    
    private ArrayList<Candidate> candidates;
    
    public CandidateManager() {
        this.candidates = new ArrayList<>();
    }
    
    /*
    * readData
    * Đọc dữ liệu từ file văn bản textFile và lưu dữ liệu vào các biến thành viên
    */
    public boolean readData(String textFile) {
        File file = null;
        Scanner fileReader = null;
        try {
            file = new File(textFile);
            fileReader = new Scanner(file);
            
            while (fileReader.hasNextLine()) {
                String[] fields = fileReader.nextLine().trim().split("\\|");
                if (fields.length != 6) {
                    continue;
                }
                
                String id = fields[0].trim();
                String name = fields[1].trim();
                String selection = fields[2].trim();
                String sex = fields[3].trim();
                int year = Integer.parseInt(fields[4].trim());
                int priority = Integer.parseInt(fields[5].trim());
                
                Candidate newCandidate = new Candidate(id, name, selection, sex, year, priority);
                
                this.candidates.add(newCandidate);
            }
            return true;
        } catch(IOException ex) {
            System.out.println("Error reading file '" + textFile + "'");
            return false;
        }  finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }
    
    /* 
    * getSelectionCandicates 
    * Trả về danh sách các thí sinh có khối thi là selection 
    */
    public ArrayList<Candidate> getSelectionCandicates(String selection) { 
        /* TODO */
    	ArrayList<Candidate> list = new ArrayList<>();
    			for(Candidate i : candidates) {
    				if(i.selection().equals(selection))
    					list.add(i);
    	}
    			return list;
    }
    
    /* 
    * getPriorityCandidates 
    * Trả về danh sách thí sinh được ưu tiên (có độ ưu tiên bằng 1)
    */
    public ArrayList<Candidate> getPriorityCandidates() {
        /* TODO */
    	ArrayList<Candidate> result = new ArrayList<>();
    	for(Candidate i : candidates) {
    		if(i.priority() == 1)
    			result.add(i);
    	}
    	return result;
    }
    
    /* 
    * sortByName
    * Trả về danh sách các thí sinh được sắp xếp theo họ và tên
    */
    public ArrayList<Candidate> sortByName() {
        /* TODO */
    	ArrayList<Candidate> result = new ArrayList<>();
    	for(int i = 0; i < result.size() - 1; i++) {
    		for(int j = i + 1; j < result.size(); j++) {
    			int c = result.get(i).name().compareTo(result.get(j).name());
    	if(c > 0) {
    		Candidate temp = result.get(i);
    		result.set(i, result.get(j));
    		result.set(j, temp);
    	}
      }
  	}
    	return result;
    }
    
    /* 
    * getSecondYoungestCandidates 
    * Trả về danh sách các thí sinh có tuổi trẻ thứ 2 trong danh sách 
    *  (ví dụ: các khách hàng có các năm sinh 1990 1991 1992 1993, 
    *  trả về danh sách các khách hàng sinh năm 1992)
    */
    public ArrayList<Candidate> getSecondYoungestCandidates() {
        /* TODO */
    	ArrayList<Candidate> list = new ArrayList<>();
    	int max = 0;
    	int max2 = 0;
    	for(Candidate c : candidates) {
    		if(c.year() > max) {
    			max = c.year();
    		}
    	}
    	
    	for(Candidate i : candidates) {
    		if(i.year() != max && i.year() > max2) {
    			max2 = i.year();
    		}
    	}
    	
    	for(Candidate i : candidates) {
    		if(i.year() == max2) {
    			list.add(i);
    		}
    	}
    	return list;
    }
    
    /*
    * printCandidatesFromArray
    * In danh sách các thí sinh từ một List đã cho
    */
    public void printCandidatesFromArray(ArrayList<Candidate> candidates) {
        if (candidates == null) {
            return;
        }
        
        for (int i = 0; i < candidates.size(); i++) {
            candidates.get(i).print();
        }
    }
    
    /*
    * printCandidates 
    * In danh sách các thí sinh được lưu trong biến thành viên candidates
    */
    public void printCandidates() {
        printCandidatesFromArray(this.candidates);
    }
    
    public static void main(String[] args) {
        CandidateManager candidateManager = new CandidateManager();
        if (!candidateManager.readData("candidates.txt")) {
            return;
        }
            
        //ArrayList<Candidate> selectionCandidates = candidateManager.getSelectionCandicates("A");
        //candidateManager.printCandidatesFromArray(selectionCandidates);
        //System.out.println();
        
        //ArrayList<Candidate> priorityCandidates = candidateManager.getPriorityCandidates();
        //candidateManager.printCandidatesFromArray(priorityCandidates);
        //System.out.println();
            
        //ArrayList<Candidate> sortedNameCandidates = candidateManager.sortByName();
        //candidateManager.printCandidatesFromArray(sortedNameCandidates);
        //System.out.println();
            
        //ArrayList<Candidate> secondYoungestCandidates = candidateManager.getSecondYoungestCandidates();
        //candidateManager.printCandidatesFromArray(secondYoungestCandidates);
    }
}