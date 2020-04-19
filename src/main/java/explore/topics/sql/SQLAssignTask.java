package explore.topics.sql;

public class SQLAssignTask {
    /**
     * Your task is to write an SQL query which assigns a difficulty rating to each task having at least one solution. The difficulty of the task depends on the average score of all candidates' solutions submitted for this task. It is possible that one candidate have submitted multiple solutions for the same task; in this case, all of those solutions should be included in the average.
     *
     * There are three difficulties: "Easy", "Medium" and "Hard".
     *
     * If the average score for the task is lower than or equal to 20, then its difficulty is "Hard".
     * If the average is higher than 20 but lower than or equal to 60, then its difficulty is "Medium".
     * If the average is higher than 60, its difficulty is "Easy".
     * For example, if the average score of the task is 50, then its difficulty is "Medium" because the average score is greater than 20 but less then 60.
     *
     * Your query should return a table containing three columns: task_id (ID of task), task_name (name of task) and difficulty − the difficulty of the task, which is one of three possible strings: "Easy", "Medium" or "Hard". Rows should be ordered by increasing task_id. If no solutions exist for some task, that task should not appear in your table.
     *
     * Examples:
     *
     * 1. Given:
     *
     *   tasks:
     *
     *     id | name
     *   -----+-------------
     *    101 | MinDist
     *    123 | Equi
     *    142 | Median
     *    300 | Tricoloring
     *
     *
     *   reports:
     *
     *    id | task_id  | candidate         | score
     *   ----+----------+-------------------+--------
     *    13 | 101      | John Smith        | 100
     *    24 | 123      | Delaney Lloyd     | 34
     *    37 | 300      | Monroe Jimenez    | 50
     *    49 | 101      | Stanley Price     | 45
     *    51 | 142      | Tanner Sears      | 37
     *    68 | 142      | Lara Fraser       | 3
     *    83 | 300      | Tanner Sears      | 0
     *
     * your query should return:
     *
     *     task_id | task_name    | difficulty
     *    ---------+--------------+------------
     *         101 | MinDist      | Easy
     *         123 | Equi         | Medium
     *         142 | Median       | Hard
     *         300 | Tricoloring  | Medium


    /** TABLE DEFINITION
     * create table tasks (
     *             id integer not null,
     *             name varchar(40) not null,
     *     unique(id)
     *   );
     *
     *     create table reports (
     *             id integer not null,
     *             task_id integer not null,
     *             candidate varchar(40) not null,
     *     score integer not null,
     *     unique(id)
     *   );
     */

    /** TABLE INSERT
     *
     *
     *     insert into tasks value (101, "MinDist");
     *     insert into tasks value (123, "Equi");
     *     insert into tasks value (142, "Median");
     *     insert into tasks value (300, "Tricoloring");
     *
     * 	insert into reports values (14, 101, "John Smith", 100);
     * 	insert into reports values (24, 123, "Delaney Lloyd", 34);
     * 	insert into reports values (37, 300, "Monroe Jimenez", 50);
     * 	insert into reports values (49, 101, "Stanley Price", 45);
     * 	insert into reports values (51, 142, "Tanner Sears", 37);
     * 	insert into reports values (68, 142, "Lara Fraser", 3);
     * 	insert into reports values (83, 300, "Tanner Sears ", 0);
     *
     */

//    select a.id as task_id,  a.name as task_name, b.avgScore as difficulty from tasks a inner join
//            (select task_id, findLevel(avg(score)) as avgScore from reports Group by task_id) b ON
//            (a.id=b.task_id) order by task_id;
//
//    DELIMITER //
//    CREATE FUNCTION findLevel(score Float)
//    RETURNS VARCHAR(20)
//    DETERMINISTIC
//            BEGIN
//    DECLARE scoreLevel VARCHAR(20);
//    IF score > 60 THEN
//    SET scoreLevel = 'EASY';
//    ELSEIF (score > 20 AND score <= 60) THEN
//    SET scoreLevel = 'MEDIUM';
//    ELSEIF score <= 20 THEN
//    SET scoreLevel = 'HARD';
//    END IF;
//    RETURN scoreLevel;
//    END//
//            DELIMITER ;

}
