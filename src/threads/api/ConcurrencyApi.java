package threads.api;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * java.util.concurrent API samples.
 * 
 * @author BartBien
 *
 */
public class ConcurrencyApi
{
	public static void main(String[] args)
	{
		/**
		 * 
		 */
		Semaphore semaphore = new Semaphore(2);

		/**
		 * 
		 */
		Lock locker = new ReentrantLock();

		/**
		 * 
		 */
		CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

		/**
		 * The lock for guarding barrier entry
		 * 
		 */
		ReentrantLock lock = new ReentrantLock();

		/**
		 * Condition to wait on until tripped
		 * 
		 */
		Condition trip = lock.newCondition();

		/**
		 * 
		 */
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

		// -----------------------------------------
		// ----------- Concurrency collection
		// -----------------------------------------
		/**
		 * 
		 */
		// ConcurrentHashMap<K, V>

		/**
		 * 
		 */
		// ConcurrentLinkedDeque<E>

		/**
		 * 
		 */
		// ConcurrentLinkedQueue<E>

		/**
		 * 
		 */
		// ConcurrentMap<K, V>

		/**
		 * 
		 */
		// ConcurrentNavigableMap<K, V>

		/**
		 * 
		 */
		// ConcurrentSkipListMap<K, V>

		/**
		 * 
		 */
		// ConcurrentSkipListSet<E>
	}
}
