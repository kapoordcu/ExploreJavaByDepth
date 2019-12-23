package explore.topics.design.aState;

public class StateExample {
    public static void main(String[] args) {
        TaskContext context = new TaskContext();
        context.getStatus();
    }


}

class TaskContext {
    private TaskState taskState = new InDevelopment();

    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public void getStatus() {
        taskState.prevState(this);
        taskState.currentState();
        taskState.nextState(this);
    }
}

interface TaskState {
    void prevState(TaskContext ctx);
    void currentState();
    void nextState(TaskContext ctx);

}

class InDevelopment implements TaskState {

    @Override
    public void prevState(TaskContext ctx) {
        System.out.println("Prev state: Did not start.");
    }

    @Override
    public void currentState() {
        System.out.println("Current state: In Development");
    }

    @Override
    public void nextState(TaskContext ctx) {
        ctx.setTaskState(new InReview());
        System.out.println("next state " + ctx.getTaskState());
    }
}

class InReview implements TaskState {

    @Override
    public void prevState(TaskContext ctx) {
        ctx.setTaskState(new InDevelopment());
    }

    @Override
    public void currentState() {
        System.out.println(this + "In Review");
    }

    @Override
    public void nextState(TaskContext ctx) {
        ctx.setTaskState(new InRelease());
    }
}

class InRelease implements TaskState {

    @Override
    public void prevState(TaskContext ctx) {
        ctx.setTaskState(new InReview());
    }

    @Override
    public void currentState() {
        System.out.println(this + "In Release");
    }

    @Override
    public void nextState(TaskContext ctx) {
        System.out.println(ctx.getTaskState() + "will be closed");
    }
}