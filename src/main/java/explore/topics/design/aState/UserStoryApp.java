package explore.topics.design.aState;

public class UserStoryApp {
    public static void main(String[] args) {
        StoryContext ctx = new StoryContext();
        ctx.status();

        System.out.println("--------------------");
        ctx.setStatus(new InSprint());
        ctx.status();

        System.out.println("--------------------");
        ctx.setStatus(new Release());
        ctx.status();

    }
}

class StoryContext {
    private Status status = new BackLogStatus();

    public void setStatus(Status status) {
        this.status = status;
    }

    public void status() {
        status.current(this);
    }

}

interface Status {
    void current(StoryContext ctx);
}

class BackLogStatus implements Status {

    public void prev(StoryContext ctx) {
        System.out.println("NA");
    }

    @Override
    public void current(StoryContext ctx) {
        prev(ctx);
        System.out.println("In Backlog");
        next(ctx);
    }

    public void next(StoryContext ctx) {
        System.out.println("Will be moved to current sprint");
    }

}

class InSprint implements Status {

    public void prev(StoryContext ctx) {
        System.out.println("Was In Backlog");
    }

    @Override
    public void current(StoryContext ctx) {
        prev(ctx);
        System.out.println("In Sprint");
        next(ctx);

    }

    public void next(StoryContext ctx) {
        System.out.println("Will be moved to release pipeline");
    }

}

class Release implements Status {

    public void prev(StoryContext ctx) {
        System.out.println("Was In Sprint");
    }

    @Override
    public void current(StoryContext ctx) {
        prev(ctx);
        System.out.println("In Release pipeline");
        next(ctx);

    }

    public void next(StoryContext ctx) {
        System.out.println("Will be closed");
    }

}