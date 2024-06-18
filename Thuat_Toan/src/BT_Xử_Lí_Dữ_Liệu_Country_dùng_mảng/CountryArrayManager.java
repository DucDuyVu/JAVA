package BT_Xử_Lí_Dữ_Liệu_Country_dùng_mảng;

import java.util.*;

public class CountryArrayManager {
    private CountryData[] countryDataArray; // Dữ liệu của các nước
    private int length; // Độ dài mảng có dữ liệu, những index lớn hơn hoặc bằng length là null
    private int increment; // Mỗi lần thêm dữ liệu, nếu không đủ chỗ thì cấp phát thêm increment phần tử cho mảng

    // Hàm dựng
    // increment là lượng mỗi lần cấp phát thêm, mặc định bằng 10
    // Khi chưa có dữ liệu, length = 0
    public CountryArrayManager() {
        this.increment = 10;
        countryDataArray = new CountryData[this.increment];
        this.length = 0;
    }

    // Hàm dựng
    // Cấp phát cho mảng capacity phần tử
    // Mảng chưa có dữ liệu nên length = 0
    public CountryArrayManager(int capacity) {
        countryDataArray = new CountryData[capacity];
        this.length = 0;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public CountryData[] getCountryDataArray() {
        return this.countryDataArray;
    }

    // Hàm correct dùng để chuẩn hóa dữ liệu lưu trong mảng
    // Khi mảng có phần tử là null thì tất cả những phần tử sau đó phải là null
    // Mảng chỉ chứa dữ liệu từ chỉ số 0 đến chỉ số length - 1
    private void correct() {
        int nullFirstIndex = 0;
        for (int i = 0; i < this.countryDataArray.length; i++) {
            if (this.countryDataArray[i] == null) {
                nullFirstIndex = i;
                break;
            }
        }

        if (nullFirstIndex > 0) {
            this.length = nullFirstIndex - 1;
            for (int i = nullFirstIndex; i < this.countryDataArray.length; i++) {
                this.countryDataArray[i] = null;
            }
        }
    }

    // Hàm dùng để cấp phát thêm phần tử cho mảng khi cần thiết.
    // Giả sử khi muốn thêm phần tử vào mảng, nhưng mảng đã hết chỗ, nên cần phải cấp phát thêm phần tử cho mảng.
    // Vì mảng có độ dài cố định, nên cần phải cấp phát lại mảng khác có độ dài lớn hơn, sau đó copy dữ liệu ở mảng cũ sang mảng mới.
    private void allocateMore() {
        CountryData[] newArray = new CountryData[this.length + this.increment];
        System.arraycopy(this.countryDataArray, 0, newArray, 0, this.countryDataArray.length);
        this.countryDataArray = newArray;
    }

    // Thêm dữ liệu vào vị trí cuối.
    // Vì Manager quản lý mảng chỉ có length phần tử chứa dữ liệu, phần còn lại là null, nên vị trí thêm vào chính là vị trí có chỉ số length.
    // Trước khi thêm cần phải kiểm tra xem mảng có còn chỗ để thêm hay không.
    // Nếu còn thì thêm vào ở vị trí length, nếu không còn thì phải cấp phát thêm phần tử cho mảng bằng cách gọi hàm allocateMore(),
    // sau đó thêm dữ liệu vào, tăng length lên 1 đơn vị.
    public void append(CountryData countryData) {
        /* TODO */
    	if(length >= countryDataArray.length) {
    		allocateMore();
    	}
    	countryDataArray[length++] = countryData;
    }

    // Thêm dữ liệu vào vị trí index.
    // Trước khi thêm cần phải kiểm tra xem mảng có còn chỗ để thêm hay không.
    // Nếu còn thì thêm dữ liệu vào ở vị trí index, nếu không còn thì phải cấp phát thêm phần tử cho mảng bằng cách gọi hàm allocateMore(),
    // sau đó thêm dữ liệu vào, tăng length lên 1 đơn vị.
    // Vì cấu trúc mảng sau khi được cấp phát là cố định, nên thêm phần tử vào vị trí index có nghĩa là dịch chuyển dữ liệu sau vị trí index sang 
    // phải 1 đơn vị, sau đó đặt dữ liệu mới vào vị trí index.
    public void addCountry(CountryData countryData, int index) {
        /* TODO */
    	if(index < 0 || index > length) {
    		throw new IndexOutOfBoundsException("Index out of bounds");
    	}
    	if(length >= countryDataArray.length) {
    		allocateMore();
    	}
    	for(int i = length; i > index; i--) {
    		countryDataArray[i] = countryDataArray[i-1];
    	}
    	 countryDataArray[index] = countryData;
    	 length++;
    }


    // Xóa dữ liệu ở vị trí index.
    // Vì cấu trúc mảng sau khi cấp phát là cố định, nên xóa phần tử ở vị trí index có nghĩa là dịch chuyển những dữ liệu sau vị trí index 
    // sang trái 1 đơn vị, gán cho dữ liệu ở vị trí length bằng null, độ dài length giảm đi 1 đơn vị.
    public void removeCountry(int index) {
        /* TODO */
    	if(index < 0 || index >= length) {
    		throw new IndexOutOfBoundsException("Index out of bounds");
  
    	}
    	for(int i = index; i < length - 1; i++) {
    		countryDataArray[i] = countryDataArray[i+1];
    		
    	}
    	countryDataArray[--length] = null;
    	
    }

    // Lấy dữ liệu ở vị trí index
    public CountryData countryDataAt(int index) {
        /* TODO */
    	if(index < 0 || index >= length) {
    		throw new IndexOutOfBoundsException("Index out of bounds");
    	}
    	return countryDataArray[index]; 
    }

    // Sắp xếp dữ liệu theo thứ tự dân số (population) tăng dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort.
    public CountryData[] sortIncreasingByPopulation() {
        /* TODO */
        CountryData[] sortedArray = Arrays.copyOf(countryDataArray,length);
    	for(int i = 0; i < sortedArray.length - 1; i++) {
    		int minIndex = i;
    		for(int j = i + 1; j < sortedArray.length; j++) {
    			if(sortedArray[j].getPopulation() < sortedArray[minIndex].getPopulation()) {
    				minIndex = j;
    			}
    		}
    		CountryData temp = sortedArray[minIndex];
    		sortedArray[minIndex] = sortedArray[i];
    		sortedArray[i] = temp;
    	}
    	return sortedArray;
    }
    
    // Sắp xếp dữ liệu theo thứ tự dân số (population) giảm dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort.
    public CountryData[] sortDecreasingByPopulation() {
        /* TODO */
    	CountryData[] arr = Arrays.copyOf(countryDataArray, length);
    	for(int i = 0; i < arr.length - 1; i++) {
    		int maxIndex = i;
    		for(int j = i + 1; j < arr.length; j++) {
    			if(arr[j].getPopulation() > arr[maxIndex].getPopulation()) {
    				maxIndex = j;
    			}
    		}
    		CountryData tem = arr[maxIndex];
    		arr[maxIndex] = arr[i];
    		arr[i] =tem;
    	}
    	return arr;
    }

    // Sắp xếp dữ liệu theo thứ tự diện tích (area) tăng dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort.
    public CountryData[] sortIncreasingByArea() {
        /* TODO */
    	CountryData[] arr = Arrays.copyOf(countryDataArray, length);
    	for(int i = 0; i < arr.length - 1; i++) {
    		int minIndex = i;
    		for(int j = i + 1; j < arr.length; j++) {
    			if(arr[j].getArea() < arr[minIndex].getArea()) {
    				minIndex = j;
    			}
    		}
    		CountryData temp = arr[minIndex];
    		arr[minIndex] = arr[i];
    		arr[i] = temp;
    	}
    	return arr;
    }

    // Sắp xếp dữ liệu theo thứ tự diện tích (area) giảm dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort.
    public CountryData[] sortDecreasingByArea() {
        /* TODO */
    	CountryData[] arr = Arrays.copyOf(countryDataArray, length);
    	for(int i = 0; i < arr.length - 1; i++) {
    		int maxIndex = i;
    		for(int j = i + 1; j < arr.length; j++) {
    			if(arr[j].getArea() > arr[maxIndex].getArea()) {
    				maxIndex = j;
    			}
    		}
    		CountryData temp = arr[maxIndex];
    		arr[maxIndex] = arr[i];
    		arr[i] = temp;
    	}
    	return arr;
    }

    // Sắp xếp dữ liệu theo thứ tự gdp tăng dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort.
    public CountryData[] sortIncreasingByGdp() {
        /* TODO */
    	CountryData[] arr = Arrays.copyOf(countryDataArray, length);
    	for(int i = 0; i < arr.length - 1; i++) {
    		int minIndex = i;
    		for(int j = i + 1; j < arr.length; j++) {
    			if(arr[j].getGdp() < arr[minIndex].getGdp()) {
    				minIndex = j;
    			}
    		}
    		CountryData temp = arr[minIndex];
    		arr[minIndex] = arr[i];
    		arr[i] = temp;
    	}
    	return arr;
    }

    // Sắp xếp dữ liệu theo thứ tự gdp giảm dần.
    // Hàm sắp xếp không nên làm thay đổi mảng dữ liệu gốc.
    // Vì vậy cấn cấp phát một mảng mới có độ dài là length, copy dữ liệu gốc sang mảng mới,
    // sau đó sắp xếp trên mảng mới, và trả ra ngoài hàm mảng mới đã được sắp xếp.
    // Nếu cần in thông tin theo dân số tăng dần, in thông tin từ mảng dữ liệu mới này.
    // Việc sắp xếp có thể sử dụng các thuật toán sắp xếp, như sellection sort, bubble sort, insertion sort.
    public CountryData[] sortDecreasingByGdp() {
        /* TODO */
    	CountryData[] arr = Arrays.copyOf(countryDataArray, length);
    	for(int i = 0; i < arr.length - 1; i++) {
    		int maxIndex = i;
    		for(int j = i + 1; j < arr.length; j++) {
    			if(arr[j].getGdp() > arr[maxIndex].getGdp()) {
    				maxIndex = j;
    			}
    		}
    		CountryData temp = arr[maxIndex];
    		arr[maxIndex] = arr[i];
    		arr[i] = temp;
    	}
    	return arr;
    }

    // Lọc ra những nước ở vùng continent (ví dụ, Châu Á).
    // Duyện từ đầu mảng đến cuối mảng, xác định xem có bao nhiêu nước thuộc vùng continent,
    // cấp phát một mảng đủ để chứa dữ liệu, sau đó duyệt lại qua mảng để thêm những nước trong vùng continent 
    // vào mảng mới vừa cấp phát. (Có thể làm theo cách khác).
    public CountryData[] filterContinent(String continent) {
        /* TODO */
    	int count = 0;
    	for(int i = 0; i < length; i++) {
    		if(countryDataArray[i].getContinent().equals(continent)) {
    			count++;
    		}
    	}
    	CountryData[] result = new CountryData[count];
    	int index = 0;
    	for(int i = 0; i < length; i++) {
    		if(countryDataArray[i].getContinent().equals(continent)) {
    			result[index++] = countryDataArray[i];
    		}
    	}
    	return result;
    }

    // Lọc ra những nước (howMany nước) có dân số đông nhất
    // Có thể làm như sau.
    // Sắp xếp dữ liệu theo thứ tự dân số giảm dần. Cấp phát mảng mới có howMany phần tử,
    // copy howMany dữ liệu từ mảng đã sắp xếp vào mảng mới vừa cấp phát.
    // Trả ra mảng mới vừa copy.
    public CountryData[] filterMostPopulousCountries(int howMany) {
        /* TODO */
    	CountryData[] arr = sortDecreasingByPopulation();
    	CountryData[] result = new CountryData[Math.min(howMany, arr.length)];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = arr[i];
    	}
    	return result;
    }

    // Lọc ra howMany nước có dân số ít nhất.
    public CountryData[] filterLeastPopulousCountries(int howMany) {
        /* TODO */
    	CountryData[] arr = sortIncreasingByPopulation();
    	CountryData[] result = new CountryData[Math.min(howMany, arr.length)];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = arr[i];
    	}
    	return result;

    }

    // Lọc ra howMany nước có diện tích lớn nhất.
    public CountryData[] filterLargestAreaCountries(int howMany) {
        /* TODO */
    	CountryData[] arr = sortDecreasingByArea();
    	CountryData[] result = new CountryData[Math.min(howMany, arr.length)];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = arr[i];
    	}
    	return result;

    }

    // Lọc ra howMany nước có diện tích nhỏ nhất.
    public CountryData[] filterSmallestAreaCountries(int howMany) {
        /* TODO */
    	CountryData[] arr = sortIncreasingByArea();
    	CountryData[] result = new CountryData[Math.min(howMany, arr.length)];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = arr[i];
    	}
    	return result;

    }

    // Lọc ra howMany nước có GDP cao nhất.
    public CountryData[] filterHighestGdpCountries(int howMany) {
        /* TODO */
    	CountryData[] arr = sortDecreasingByGdp();
    	CountryData[] result = new CountryData[Math.min(howMany, arr.length)];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = arr[i];
    	}
    	return result;

    }

    // Lọc ra howMany nước có GDP thấp nhất.
    public CountryData[] filterLowestGdpCountries(int howMany) {
        /* TODO */
    	CountryData[] arr = sortIncreasingByGdp();
    	CountryData[] result = new CountryData[Math.min(howMany, arr.length)];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = arr[i];
    	}
    	return result;

    }

    // Hàm lấy danh sách các nước theo code, là String có format dạng, ví dụ [USA VNM].
    public static String codeOfCountriesToString(CountryData[] countryDataArray, int length) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (int i = 0; i < length; i++) {
            CountryData countryData = countryDataArray[i];
            codeOfCountries.append(countryData.getCode()).append(" ");
        }
        return codeOfCountries.toString().trim() + "]";
    }

    // In đầy đủ thông tin các nước trong một mảng, mỗi mảng in trên 1 dòng.
    // Ví dụ:
    // [CountryData[code='IND', name='India', population=1405888536, area=3287590.0, gdp=1927.7, continent='Asia']
    //  CountryData[code='PAK', name='Pakistan', population=229248330, area=881912.0, gdp=1188.9, continent='Asia']]
    public static void print(CountryData[] countryDataArray, int length) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (int i = 0; i < length; i++) {
            CountryData country = countryDataArray[i];
            countriesString.append(country.toString()).append("\n");
        }
        System.out.print(countriesString.toString().trim() + "]");
    }
}