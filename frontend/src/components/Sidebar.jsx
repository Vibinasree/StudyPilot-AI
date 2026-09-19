import { NavLink, useNavigate } from "react-router-dom";
import {
  BookOpen,
  BrainCircuit,
  CalendarDays,
  LayoutDashboard,
  LogOut,
  Sparkles,
  Trophy,
  X
} from "lucide-react";

function Sidebar({ mobileOpen, closeSidebar }) {
  const navigate = useNavigate();

  const navigation = [
    {
      label: "Dashboard",
      path: "/dashboard",
      icon: LayoutDashboard
    },
    {
      label: "Topics",
      path: "/topics",
      icon: BookOpen
    },
    {
      label: "Study Plans",
      path: "/study-plans",
      icon: CalendarDays
    },
    {
      label: "Quizzes",
      path: "/quizzes",
      icon: Trophy
    },
    {
      label: "AI Study",
      path: "/ai-study",
      icon: Sparkles
    }
  ];

  const logout = () => {
    localStorage.removeItem("studypilot_token");
    localStorage.removeItem("studypilot_user");
    navigate("/login");
  };

  return (
    <aside className={`sidebar ${mobileOpen ? "sidebar-open" : ""}`}>
      <div className="sidebar-header">
        <div className="brand">
          <div className="brand-icon">
            <BrainCircuit size={21} />
          </div>

          <span>StudyPilot</span>
        </div>

        <button
          className="mobile-close"
          onClick={closeSidebar}
          aria-label="Close menu"
        >
          <X size={20} />
        </button>
      </div>

      <div className="sidebar-section-label">
        WORKSPACE
      </div>

      <nav className="sidebar-nav">
        {navigation.map((item) => {
          const Icon = item.icon;

          return (
            <NavLink
              key={item.path}
              to={item.path}
              onClick={closeSidebar}
              className={({ isActive }) =>
                `sidebar-link ${isActive ? "active" : ""}`
              }
            >
              <Icon size={19} />
              <span>{item.label}</span>
            </NavLink>
          );
        })}
      </nav>

      <div className="sidebar-bottom">
        <div className="sidebar-ai-card">
          <Sparkles size={18} />

          <div>
            <strong>Study smarter</strong>
            <p>Use AI to understand difficult topics.</p>
          </div>
        </div>

        <button className="logout-button" onClick={logout}>
          <LogOut size={18} />
          <span>Sign out</span>
        </button>
      </div>
    </aside>
  );
}

export default Sidebar;