import java.util.*;
/*
数据传输时，一个大数据可分为多个chunk，分别发送。多个小数据可合成一个chunk，一起发送。设计processChunk(byte[] chunk), 可以call多次，读取chunk里包含的信息。每个数据读取完，调用processMessage(byte[] mess)接口。其中chunk里 包含 4个byte 的header，记录下一个数据的byte数。. Waral 鍗氬鏈夋洿澶氭枃绔�,
Chunk1：[0,0,0,8, 1,2,3,4,5]
Chunk2 : [6,7,8,0,0,0,2,1,2,0,0,0,3,1,2,3]

H1: [0,0,0,8]
M1: [1,2,3,4,5,6,7,8]  
H2: [0,0,0,2]
M2: [1,2]
H3: [0,0,0,3] 
M3: [1,2,3]

PS: [0,0,1,0] -> length 256
*/

class Solution {
	
	int mess_i = 0;
	byte[] mess;
	int mess_len = -1;
	int chunk_i = 0;
	public void processChunk(byte[] chunk) {
		while(chunk_i < chunk.length) {
			if(mess_len == -1) {
				newMess(chunk);
			}
			read(chunk);
		}
		chunk_i = 0;
		
	}
	public void newMess(byte[] chunk) {
		mess_len = getLen(chunk);
	

		mess = new byte[mess_len];
	}
	public void read(byte[] chunk) {
		while(chunk_i < chunk.length && mess_i < mess.length) {
			mess[mess_i++] = chunk[chunk_i++];
		}
		if(mess_i == mess.length) {
			mess_len = -1;
			mess_i = 0;
			processMess(mess);
		}
	}
	public int getLen(byte[] chunk) {
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			
			System.out.println((int) chunk[chunk_i] & 0xFF);
			sum = 256 * sum + ((int) chunk[chunk_i++] & 0xFF); // signed byte in java convert to unsigned
			
		}
		System.out.println(sum);
		return sum;
	}
	public void processMess(byte[] mess) {
		System.out.println(Arrays.toString(mess));
	}
	
	
	public static void main(String[] args) {
		
		
		
		
    	Solution t = new Solution();
    	
    	byte[] c1 = {0,0,0,8,1,2,3,4};
    	byte[] c2 = {5,6,7,8,0,0,0,2,1,2,100,0,3,0,1,2,3,4,5};
    	t.processChunk(c1);
    	t.processChunk(c2);
	}

}
