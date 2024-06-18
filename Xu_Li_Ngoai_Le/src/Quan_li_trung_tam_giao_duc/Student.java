package Quan_li_trung_tam_giao_duc;

/** Class Student: 
 * Dẫn xuất từ (con của) lớp Person. Cần hoàn thiện các phương thức chưa có
 * nhưng phải giữ nguyên mẫu phương thức (khai báo, đối số, kiểu trả về)
 * Có thể thay đổi giá trị sau lệnh return cuối các phương thức nhưng cần
 * giữ nguyên kiểu trả về. Có thể bổ sung phương thức nếu cần, nhưng phải 
 * giữ lại đầy đủ các phương thức đã được khai báo sẵn
 * */

public class Student extends Person{
    private String  majors = "UnRegistered"; 
    private double scoreAvg;
    
    public Student(){
        // bổ sung mã lệnh ở đây 
    	super();
        scoreAvg = 0.0;
    }
    
    public Student(String SVcode, String mail, String majors, double score,
                    String name, Date birthday, boolean gender, String address){
        // bổ sung mã lệnh ở đây 
    	super(SVcode, name, birthday, gender, mail, address);
    	this.majors = majors;
    	this.scoreAvg = score;
    }    

    
    public String getMajors(){
        // bổ sung mã lệnh ở đây! Có thể sửa giá trị trả về của lệnh return
        // nhưng không thay đổi kiểu trả về!
        return majors;
    }   
    
    public double getScore(){
        // bổ sung mã lệnh ở đây! Có thể sửa giá trị trả về của lệnh return
        // nhưng không thay đổi kiểu trả về!
        return scoreAvg;
    }

    public double getPayment(double baseAmount){
    
        // bổ sung mã lệnh ở đây! Có thể sửa giá trị trả về của lệnh return
        // nhưng không thay đổi kiểu trả về!
    	double result;
    	if(scoreAvg < 4) {
    		result = baseAmount * 1.5;
    	}
    	else if(scoreAvg < 8) {
    		result = baseAmount;
    	}
    	else if(scoreAvg < 9) {
    		result = baseAmount * 0.75;
    	}
    	else {
    		result = baseAmount * 0.5;
    	}
        return result;
    }    


    public String toString(){
        String str =  "Student Code: " + super.toString() + "; AVG score:" + String.valueOf(scoreAvg) + " Majors: " + majors;
        // bổ sung mã lệnh ở đây! Có thể sửa giá trị trả về của lệnh return
        // nhưng không thay đổi kiểu trả về!
        return str;
    }

}