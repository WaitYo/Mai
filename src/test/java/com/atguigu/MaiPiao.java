package com.atguigu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//三个售票元售票
public class MaiPiao {

	public static void main(String[] args) {
		
			Piao p = new Piao();
			new Thread(new Runnable() {
				@Override
				public void run()
				{
					for (int i = 1; i <=10; i++) 
					{
						p.sale();
					}
				}
			},"A").start();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i = 1;i<=10;i++) {
						p.sale();
					}
				}
			}, "b").start();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int j = 1;j<=10;j++) {
						p.sale();
					}
					
				}
			}, "C").start();
		}

	}
	class  Piao {
		//private static final int MAX_VALUE =10;
		private int sum = 10;
		private Lock lock = new ReentrantLock();
		

		public void sale() {
			lock.lock();
				try {
				if(sum>0) {
					System.out.println(Thread.currentThread().getName() + "卖出一张票，号码是" + (sum--) +"剩余" + sum +"张票");
				}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		}

