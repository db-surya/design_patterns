package Adapter;

interface Pen {
    void write(String text);
}

// Adaptee: PilotPen (already existing class)
class PilotPen {
    public void mark(String text) {
        System.out.println("PilotPen writes: " + text);
    }
}

// Adapter: Adapts PilotPen to the Pen interface
class PenAdapter implements Pen {
    private PilotPen pilotPen = new PilotPen();

    @Override
    public void write(String text) {
        pilotPen.mark(text); // Delegates the call to the adaptee
    }
}

// Client: AssignmentWork
class AssignmentWork {
    private Pen pen;

    public void setPen(Pen pen) {
        this.pen = pen; // Uses the adapter
    }

    public void writeAssignment(String text) {
        if (pen != null) {
            pen.write(text);
        } else {
            System.out.println("No pen available to write!");
        }
    }
}

// Main class to demonstrate the Adapter Pattern
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AssignmentWork assignment = new AssignmentWork();

        // Using the PenAdapter to adapt PilotPen to Pen interface
        Pen adapter = new PenAdapter();
        assignment.setPen(adapter);

        // Writing the assignment
        assignment.writeAssignment("Adapter Design Pattern is awesome!");
    }
}
