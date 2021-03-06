package jadx.gui.jobs;

import java.util.List;

public interface IBackgroundTask {

	String getTitle();

	List<Runnable> scheduleJobs();

	/**
	 * Called on executor thread after the all jobs finished.
	 */
	default void onDone(ITaskInfo taskInfo) {
	}

	/**
	 * Executed on the Event Dispatch Thread after the all jobs finished.
	 */
	default void onFinish(ITaskInfo taskInfo) {
	}

	default boolean canBeCanceled() {
		return false;
	}

	/**
	 * Global (for all jobs) time limit in milliseconds (0 - to disable).
	 */
	default int timeLimit() {
		return 0;
	}

	/**
	 * Executor will check memory usage on every tick and cancel job if no free memory available.
	 */
	default boolean checkMemoryUsage() {
		return false;
	}
}
