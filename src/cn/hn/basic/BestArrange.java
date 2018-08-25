package cn.hn.basic;

import java.util.Arrays;
import java.util.Comparator;
//安排时间表,使得进行的项目最多
public class BestArrange {

	public static class Program {
		public int start;//项目开始时间
		public int end;//结束时间

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	//根据结束时间排序
	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	public static int bestArrange(Program[] programs, int start) {
		//根据结束时间排序,结束时间早的排在前面
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
			//如果当前时间小于项目开始时间,计数加一
			if (start <= programs[i].start) {
				result++;
				//当前时间改成该项目的结束时间
				start = programs[i].end;
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
