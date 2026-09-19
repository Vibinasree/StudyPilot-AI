import {
  ArrowRight,
  CheckCircle2,
  Clock3,
  HelpCircle,
  Trophy
} from "lucide-react";
import Layout from "../components/Layout";

function Quizzes() {
  const quizzes = [
    {
      title: "Java Collections",
      questions: 15,
      difficulty: "Medium",
      score: "92%",
      attempts: 3
    },
    {
      title: "Spring Boot Basics",
      questions: 20,
      difficulty: "Easy",
      score: "86%",
      attempts: 2
    },
    {
      title: "DSA Arrays & Two Pointers",
      questions: 15,
      difficulty: "Medium",
      score: "80%",
      attempts: 4
    },
    {
      title: "SQL Fundamentals",
      questions: 20,
      difficulty: "Easy",
      score: "88%",
      attempts: 2
    }
  ];

  return (
    <Layout
      title="Quizzes"
      subtitle="Test your understanding and identify knowledge gaps."
    >
      <div className="quiz-summary">
        <div className="quiz-summary-card">
          <Trophy size={21} />
          <div>
            <span>Average score</span>
            <strong>86%</strong>
          </div>
        </div>

        <div className="quiz-summary-card">
          <CheckCircle2 size={21} />
          <div>
            <span>Completed</span>
            <strong>12</strong>
          </div>
        </div>

        <div className="quiz-summary-card">
          <HelpCircle size={21} />
          <div>
            <span>Questions answered</span>
            <strong>186</strong>
          </div>
        </div>
      </div>

      <div className="quiz-grid">
        {quizzes.map((quiz) => (
          <article className="quiz-card" key={quiz.title}>
            <div className="quiz-card-icon">
              <Trophy size={22} />
            </div>

            <span className="difficulty">
              {quiz.difficulty}
            </span>

            <h3>{quiz.title}</h3>

            <div className="quiz-meta">
              <span>
                <HelpCircle size={15} />
                {quiz.questions} questions
              </span>

              <span>
                <Clock3 size={15} />
                ~20 min
              </span>
            </div>

            <div className="quiz-score">
              <div>
                <span>Best score</span>
                <strong>{quiz.score}</strong>
              </div>

              <small>
                {quiz.attempts} attempts
              </small>
            </div>

            <button className="quiz-button">
              Start quiz
              <ArrowRight size={16} />
            </button>
          </article>
        ))}
      </div>
    </Layout>
  );
}

export default Quizzes;