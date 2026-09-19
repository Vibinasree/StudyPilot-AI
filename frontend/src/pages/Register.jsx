import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../services/api";

function Register() {
const navigate = useNavigate();

const [form, setForm] = useState({
name: "",
email: "",
password: ""
});

const [error, setError] = useState("");
const [loading, setLoading] = useState(false);

const handleChange = (event) => {
setForm({
...form,
[event.target.name]: event.target.value
});
};

const handleSubmit = async (event) => {
event.preventDefault();
setError("");
setLoading(true);


try {
  await api.post("/auth/register", form);
  navigate("/login");
} catch (err) {
  setError(
    err.response?.data?.error ||
    "Registration failed. Please try again."
  );
} finally {
  setLoading(false);
}


};

return ( <div className="auth-layout"> <div className="auth-showcase"> <h1>StudyPilot AI</h1> <p>Your AI-powered study companion.</p> </div>


  <div className="auth-panel">
    <div className="auth-form-card">
      <h2>Create Account</h2>
      <p>Start your personalized learning journey.</p>

      {error && <div className="auth-error">{error}</div>}

      <form onSubmit={handleSubmit}>
        <div>
          <label>Name</label>
          <input
            type="text"
            name="name"
            value={form.name}
            onChange={handleChange}
            placeholder="Enter your name"
            required
          />
        </div>

        <div>
          <label>Email</label>
          <input
            type="email"
            name="email"
            value={form.email}
            onChange={handleChange}
            placeholder="Enter your email"
            required
          />
        </div>

        <div>
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={form.password}
            onChange={handleChange}
            placeholder="Create a password"
            required
          />
        </div>

        <button type="submit" disabled={loading}>
          {loading ? "Creating Account..." : "Create Account"}
        </button>
      </form>

      <p>
        Already have an account?{" "}
        <button
          type="button"
          onClick={() => navigate("/login")}
        >
          Login
        </button>
      </p>
    </div>
  </div>
</div>

);
}

export default Register;
