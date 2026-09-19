import { useState } from "react";
import {
  BrainCircuit,
  LoaderCircle,
  Sparkles
} from "lucide-react";
import Layout from "../components/Layout.jsx";
import api from "../services/api.js";

function AIStudy() {
  const [topic, setTopic] = useState("");
  const [level, setLevel] = useState("Beginner");
  const [request, setRequest] = useState("");
  const [loading, setLoading] = useState(false);
  const [result, setResult] = useState("");
  const [error, setError] = useState("");

  const generateStudyMaterial = async (event) => {
    event.preventDefault();

    if (!topic.trim()) {
      setError("Please enter a topic.");
      return;
    }

    setLoading(true);
    setError("");
    setResult("");

    try {
      const response = await api.post("/ai/study", {
        topic,
        level,
        request
      });

      const data = response.data;

      setResult(
        data.content ||
        data.response ||
        data.message ||
        "Study material generated successfully."
      );
    } catch (err) {
      setError(
        err.response?.data?.error ||
        "The AI service is not configured yet. The frontend is ready for the AI integration."
      );
    } finally {
      setLoading(false);
    }
  };

  return (
    <Layout
      title="AI Study"
      subtitle="Explore difficult concepts with an AI-powered study assistant."
    >
      <div className="ai-layout">
        <section className="content-card ai-form-card">
          <div className="ai-header">
            <div className="ai-icon-large">
              <Sparkles size={24} />
            </div>

            <div>
              <p className="card-eyebrow">AI LEARNING ASSISTANT</p>
              <h2>What do you want to learn?</h2>
            </div>
          </div>

          <form onSubmit={generateStudyMaterial}>
            <label>Topic</label>

            <input
              value={topic}
              onChange={(event) => setTopic(event.target.value)}
              placeholder="e.g. Binary Search Trees"
            />

            <label>Knowledge level</label>

            <select
              value={level}
              onChange={(event) => setLevel(event.target.value)}
            >
              <option>Beginner</option>
              <option>Intermediate</option>
              <option>Advanced</option>
            </select>

            <label>What do you need help with?</label>

            <textarea
              value={request}
              onChange={(event) => setRequest(event.target.value)}
              placeholder="Explain the concept, give examples, create practice questions..."
              rows="7"
            />

            {error && (
              <div className="alert error">
                {error}
              </div>
            )}

            <button
              className="primary-button large"
              disabled={loading}
            >
              {loading ? (
                <LoaderCircle className="spin" size={18} />
              ) : (
                <BrainCircuit size={18} />
              )}

              {loading
                ? "Generating..."
                : "Generate study material"}
            </button>
          </form>
        </section>

        <section className="content-card ai-result-card">
          <div className="card-header">
            <div>
              <p className="card-eyebrow">YOUR MATERIAL</p>
              <h2>Study output</h2>
            </div>

            <Sparkles size={20} />
          </div>

          {!result && !loading && (
            <div className="empty-ai">
              <BrainCircuit size={38} />

              <h3>Your study material will appear here</h3>

              <p>
                Enter a topic and tell StudyPilot what you
                want to understand.
              </p>
            </div>
          )}

          {loading && (
            <div className="empty-ai">
              <LoaderCircle className="spin" size={38} />

              <h3>Preparing your study material...</h3>

              <p>
                StudyPilot is processing your request.
              </p>
            </div>
          )}

          {result && !loading && (
            <div className="ai-result">
              {result}
            </div>
          )}
        </section>
      </div>
    </Layout>
  );
}

export default AIStudy;