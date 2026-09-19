import { useMemo, useState } from "react";
import {
  BookOpen,
  BrainCircuit,
  Database,
  FileCode2,
  Search,
  Server,
  Layers
} from "lucide-react";
import Layout from "../components/Layout";

function Topics() {
  const [search, setSearch] = useState("");

  const topics = [
    {
      name: "Java",
      category: "Programming",
      progress: 86,
      lessons: 24,
      icon: FileCode2
    },
    {
      name: "Data Structures & Algorithms",
      category: "Problem Solving",
      progress: 72,
      lessons: 48,
      icon: BrainCircuit
    },
    {
      name: "Spring Boot",
      category: "Backend",
      progress: 64,
      lessons: 28,
      icon: Server
    },
    {
      name: "React",
      category: "Frontend",
      progress: 58,
      lessons: 22,
      icon: Layers
    },
    {
      name: "PostgreSQL",
      category: "Database",
      progress: 74,
      lessons: 18,
      icon: Database
    },
    {
      name: "System Design",
      category: "Architecture",
      progress: 35,
      lessons: 20,
      icon: BookOpen
    }
  ];

  const filteredTopics = useMemo(() => {
    return topics.filter((topic) =>
      `${topic.name} ${topic.category}`
        .toLowerCase()
        .includes(search.toLowerCase())
    );
  }, [search]);

  return (
    <Layout
      title="Topics"
      subtitle="Organize and track everything you're learning."
    >
      <div className="toolbar">
        <div className="search-box">
          <Search size={18} />

          <input
            type="text"
            placeholder="Search topics..."
            value={search}
            onChange={(event) => setSearch(event.target.value)}
          />
        </div>

        <button className="primary-button">
          + Add topic
        </button>
      </div>

      <div className="topic-grid">
        {filteredTopics.map((topic) => {
          const Icon = topic.icon;

          return (
            <article className="topic-card" key={topic.name}>
              <div className="topic-top">
                <div className="topic-icon">
                  <Icon size={21} />
                </div>

                <span className="topic-category">
                  {topic.category}
                </span>
              </div>

              <h3>{topic.name}</h3>

              <p>
                {topic.lessons} learning units
              </p>

              <div className="topic-progress-header">
                <span>Progress</span>
                <strong>{topic.progress}%</strong>
              </div>

              <div className="progress-track">
                <div
                  className="progress-fill"
                  style={{ width: `${topic.progress}%` }}
                />
              </div>

              <button className="topic-action">
                Open topic
                <span>→</span>
              </button>
            </article>
          );
        })}
      </div>
    </Layout>
  );
}

export default Topics;