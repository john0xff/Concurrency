package com.phoenixjcam.util.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample
{
	private static final Lock mutex = new ReentrantLock(true);;

	public static void main(String[] args)
	{

		mutex.lock();

		// your protected code here

		mutex.unlock();
	}

}
