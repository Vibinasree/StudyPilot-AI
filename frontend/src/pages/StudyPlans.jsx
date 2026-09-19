import {
  ArrowRight,
  CalendarDays,
  CheckCircle2,
  Clock3,
  Plus,
  Target
} from "lucide-react";
import Layout from "../components/Layout";

function StudyPlans() {
  const plans = [
    {
      title: "DSA Interview Preparation",
      description:
        "Build strong problem-solving skills for software engineering interviews.",
      progress: 68,
      completed: 34,
      total: 50,
      duration: "8 weeks",
      status: "In progress"
    },
    {
      title: "Java Full Stack Revision",
      description:
        "Review Java, Spring Boot, React, databases and backend fundamentals.",
      progress: 82,
      completed: 41,
      total: 50,
      duration: "6 weeks",
      status: "In progress"
    },
    {
      title: "System Design Foundations",
      description:
        "Learn scalable architecture, APIs, caching, messaging and databases.",
      progress: 35,
      completed: 7,
      total: 20,
      duration: "4 weeks",
      status: "In progress"
    }
  ];

  return (
    <Layout
      title="Study Plans"
      subtitle="Turn your goals into structured learning plans."
    >
      <div className="plan-page-top">
        <div>
          <p className="card-eyebrow">YOUR ROADMAP</p>
          <h2>Learning plans</h2>
        </div>

        <button className="primary-button">
          <Plus size={17} />
          New plan
        </button>
      </div>

      <div className="plans-list">
        {plans.map((plan) => (
          <article className="plan-card" key={plan.title}>
            <div className="plan-card-top">
              <div className="plan-title-group">
                <div className="plan-icon">
                  <Target size={21} />
                </div>

                <div>
                  <span className="status-badge">
                    {plan.status}
                  </span>

                  <h3>{plan.title}</h3>
                  <p>{plan.description}</p>
                </div>
              </div>

              <button className="circle-arrow">
                <ArrowRight size={17} />
              </button>
            </div>

            <div className="plan-meta">
              <span>
                <CheckCircle2 size={16} />
                {plan.completed}/{plan.total} sessions
              </span>

              <span>
                <Clock3 size={16} />
                {plan.duration}
              </span>

              <span>
                <CalendarDays size={16} />
                Weekly schedule
              </span>
            </div>

            <div className="plan-progress-header">
              <strong>{plan.progress}% complete</strong>
              <span>Keep going</span>
            </div>

            <div className="progress-track">
              <div
                className="progress-fill"
                style={{ width: `${plan.progress}%` }}
              />
            </div>
          </article>
        ))}
      </div>
    </Layout>
  );
}

export default StudyPlans;