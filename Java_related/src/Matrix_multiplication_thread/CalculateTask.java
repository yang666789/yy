package Matrix_multiplication_thread;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalculateTask extends Thread {
	private int[][] A;
	private int[][] B;
	private int index;
	private int gap;
	private int[][] result;
	private CountDownLatch countDownLatch;
	//private boolean flag=true;
	
	public CalculateTask(int[][] A, int[][] B, int index, 
			int gap, int[][] result, CountDownLatch countDownLatch) {
		this.A = A;
		this.B = B;
		this.index = index;
		this.gap = gap;
		this.result = result;
		this.countDownLatch = countDownLatch;
	}

	// 计算特定范围内的结果
		public void run() {
			// TODO Auto-generated method stub
			for (int i = index * gap; i < (index + 1) * gap; i++)
				for (int j = 0; j < B[0].length; j++) {
					for (int k = 0; k < B.length; k++)
						result[i][j] += A[i][k] * B[k][j];
				}
			// 线程数减1
			
			countDownLatch.countDown();
			
		}

	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 声明和初始化
				Scanner in=new Scanner(System.in);
				long startTime;
				long endTime;
				System.out.println("请输入矩阵的行数（两个矩阵行数与列数相等）：");
				int row_A=in.nextInt();
				int col_A =row_A;
				int col_B=row_A;
				int[][] A = new int[row_A][col_A];
				int[][] B = new int[col_A][col_B];
		        //存放并行计算结果
				int[][] parallel_result = new int[A.length][B[0].length];
		        //存放串行计算结果
				int[][] serial_result = new int[A.length][B[0].length];
		        //子线程数量
				System.out.println("请输入线程数：");
				int threadNum =in.nextInt();
		        //子线程的分片计算间隔
				int gap = A.length / threadNum;
				CountDownLatch countDownLatch = new CountDownLatch(threadNum);
				// 为A和B矩阵随机赋值
				for (int i = 0; i < row_A; i++)
					for (int j = 0; j < col_A; j++) {
						A[i][j] = (int) (Math.random() * 100);
					}
				for (int i = 0; i < col_A; i++)
					for (int j = 0; j < col_B; j++) {
						B[i][j] = (int) (Math.random() * 100);
					}
				// 并行计算
				startTime = System.currentTimeMillis();
				for (int i = 0; i < threadNum; i++) {
					CalculateTask ct = new CalculateTask(A, B, i, gap, parallel_result, countDownLatch);
					ct.start();
				}
				countDownLatch.await();//等待计数为0时才往下执行代码
				endTime = System.currentTimeMillis();
				System.out.println("并行计算开始时刻:" + (startTime));
				System.out.println("并行计算结束时刻:" + (endTime));
				System.out.println("并行计算运行时间:" + (endTime - startTime));
		 
				//线程池计算
				//建立用户输入的工作线程
				//flag=false;
				CalculateTask []poolThreads=new CalculateTask[threadNum];
				for(int i=0;i<threadNum;i++)
					poolThreads[i]=new CalculateTask(A, B, i, 
							gap, parallel_result, countDownLatch);
				//建立线程池
				ExecutorService pool = Executors.newCachedThreadPool();
				startTime = System.currentTimeMillis();
				for(int i=0;i<threadNum;i++)
					pool.execute(poolThreads[i]);//将四个工作线程放入线程池中执行
				pool.shutdown();//在线程池终止前允许执行以前提交的任务
				while (true) {  
		            if (pool.isTerminated()) {   
		                break;  
		            }
		        }//用一个死循环判断线程池是否执行完成
				countDownLatch.await();
				endTime = System.currentTimeMillis();
				System.out.println("线程池计算开始时刻:" + (startTime));
				System.out.println("线程池算结束时刻:" + (endTime));
				System.out.println("线程池算运行时间:" + (endTime - startTime));
				
				
				// 串行计算
				startTime = System.currentTimeMillis();
				for (int i = 0; i < A.length; i++) {
					for (int j = 0; j < B[0].length; j++) {
						for (int k = 0; k < A[0].length; k++)
							serial_result[i][j] += A[i][k] * B[k][j];
					}
				}
				endTime = System.currentTimeMillis();
				System.out.println("串行计算开始时刻:" + (startTime));
				System.out.println("串行计算结束时刻:" + (endTime));
				System.out.println("串行计算运行时间:" + (endTime - startTime));
				
				
			}

	}

