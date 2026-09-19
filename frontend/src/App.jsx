import {
  BrowserRouter,
  Navigate,
  Route,
  Routes
} from "react-router-dom";

import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import Topics from "./pages/Topics";
import StudyPlans from "./pages/StudyPlans";
import Quizzes from "./pages/Quizzes";
import AIStudy from "./pages/AiStudy";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route
          path="/"
          element={<Navigate to="/login" replace />}
        />

        <Route
          path="/login"
          element={<Login />}
        />

        <Route
          path="/register"
          element={<Register />}
        />

        <Route
          path="/dashboard"
          element={<Dashboard />}
        />

        <Route
          path="/topics"
          element={<Topics />}
        />

        <Route
          path="/study-plans"
          element={<StudyPlans />}
        />

        <Route
          path="/quizzes"
          element={<Quizzes />}
        />

        <Route
          path="/ai-study"
          element={<AIStudy />}
        />

        <Route
          path="*"
          element={<Navigate to="/dashboard" replace />}
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;