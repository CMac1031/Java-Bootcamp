public class WeakReferenceDemo {

    public static void main(String[] args) {
        System.out.println("===== Weak Reference Demonstration =====");

        System.out.println("--- Strong Reference ---");
        Person strongPerson = new Person("Strong User", 40);
        System.out.println("Before GC : " + strongPerson);
        MemoryMonitor.triggerGarbageCollection();
        System.out.println("After GC  : " + strongPerson);
        System.out.println("Object remains because a strong reference still exists.");

        System.out.println();
        System.out.println("--- Weak Reference ---");
        // TODO: create Person weakTarget; wrap in WeakReference<Person>
        Person weakTarget = new Person("Weak User", 35);
        System.out.println("Before GC : " + weakTarget);
        weakTarget = null;
        MemoryMonitor.triggerGarbageCollection();
        // TODO: null weakTarget; trigger GC; print WeakReference.get() result
        System.out.println("After GC  : " + weakTarget);
        System.out.println("After GC via WeakReference.get() : null   # or still present if GC did not run yet\n" + "Observation:\n" +
                "- WeakReference allows GC to collect the object when only weak refs remain");


    }
}