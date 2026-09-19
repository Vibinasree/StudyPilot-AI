import {
  ArrowRight,
  BookOpen,
  BrainCircuit,
  CheckCircle2,
  Clock3,
  Flame,
  Play,
  Target,
  Trophy
} from "lucide-react";
import { useNavigate } from "react-router-dom";
import Layout from "../components/Layout";

function Dashboard() {
  const navigate = useNavigate();

  const stats = [
    {
      label: "Topics completed",
      value: "18",
      detail: "of 32 topics",
      icon: CheckCircle2
    },
    {
      label: "Study time",
      value: "24h",
      detail: "this month",
      icon: Clock3
    },
    {
      label: "Current streak",
      value: "7 days",
      detail: "Keep going!",
      icon: Flame
    },
    {
      label: "Quiz average",
      value: "84%",
      detail: "Across 12 quizzes",
      icon: Trophy
    }
  ];

  const sessions = [
    {
      title: "Binary Trees",
      subject: "Data Structures",
      duration: "45 min",
      progress: 80
    },
    {
      title: "Spring Boot Security",
      subject: "Backend Development",
      duration: "60 min",
      progress: 55
    },
    {
      title: "React Hooks",
      subject: "Frontend Development",
      duration: "40 min",
      progress: 30
    }
  ];

  return (
    <Layout
      title="Good morning 👋"
      subtitle="Here's what's happening with your learning today."
    >
      <section className="stats-grid">
        {stats.map((stat) => {
          const Icon = stat.icon;

          return (
            <div className="stat-card" key={stat.label}>
              <div className="stat-icon">
                <Icon size={19} />
              </div>

              <div>
                <p>{stat.label}</p>
                <strong>{stat.value}</strong>
                <span>{stat.detail}</span>
              </div>
            </div>
          );
        })}
      </section>

      <section className="dashboard-grid">
        <div className="content-card today-card">
          <div className="card-header">
            <div>
              <p className="card-eyebrow">TODAY'S PLAN</p>
              <h2>Continue learning</h2>
            </div>

            <button
              className="text-button"
              onClick={() => navigate("/study-plans")}
            >
              View plan
              <ArrowRight size={16} />
            </button>
          </div>

          <div className="today-main">
            <div className="today-icon">
              <BrainCircuit size={27} />
            </div>

            <div className="today-copy">
              <h3>DSA Interview Preparation</h3>
              <p>
                Continue your interview preparation with
                trees and graph algorithms.
              </p>

              <div className="progress-row">
                <div className="progress-track">
                  <div
                    className="progress-fill"
                    style={{ width: "68%" }}
                  />
                </div>

                <span>68%</span>
              </div>
            </div>

            <button
              className="primary-button"
              onClick={() => navigate("/study-plans")}
            >
              <Play size={16} />
              Continue
            </button>
          </div>
        </div>

        <div className="content-card focus-card">
          <div className="card-header">
            <div>
              <p className="card-eyebrow">YOUR FOCUS</p>
              <h2>Keep the momentum</h2>
            </div>
          </div>

          <div className="focus-content">
            <div className="focus-ring">
              <span>68%</span>
              <small>weekly goal</small>
            </div>

            <div>
              <div className="focus-item">
                <Target size={17} />
                <span>5 of 7 study days</span>
              </div>

              <div className="focus-item">
                <BookOpen size={17} />
                <span>12 topics remaining</span>
              </div>

              <div className="focus-item">
                <Trophy size={17} />
                <span>3 quizzes this week</span>
              </div>
            </div>
          </div>
        </div>
      </section>

      <section className="content-card">
        <div className="card-header">
          <div>
            <p className="card-eyebrow">UP NEXT</p>
            <h2>Study sessions</h2>
          </div>

          <button
            className="text-button"
            onClick={() => navigate("/topics")}
          >
            All topics
            <ArrowRight size={16} />
          </button>
        </div>

        <div className="session-list">
          {sessions.map((session) => (
            <div className="session-item" key={session.title}>
              <div className="session-icon">
                <BookOpen size={19} />
              </div>

              <div className="session-info">
                <strong>{session.title}</strong>
                <span>{session.subject}</span>
              </div>

              <span className="session-duration">
                {session.duration}
              </span>

              <div className="mini-progress">
                <div
                  style={{ width: `${session.progress}%` }}
                />
              </div>

              <button
                className="circle-arrow"
                onClick={() => navigate("/study-plans")}
              >
                <ArrowRight size={16} />
              </button>
            </div>
          ))}
        </div>
      </section>
    </Layout>
  );
}

export default Dashboard;