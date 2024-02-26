import React from 'react';
import QuestionAreaIndividual from './QuestionAreaIndividual';
import Editor from './Editor';
import TopNavBar from './TopNavBar';

function QuestionRowIndividual() {
  return (
    <>
      <TopNavBar />
      {Array.from({ length: 3 }).map((_, index) => (
        <div
          key={index}
          style={{
            display: 'flex',
            marginBottom: '100px',
            marginLeft: '20px'
          }}>
          <div
            className="fs-left-pane"
            style={{
              width: 'calc(45% - 6px)',
              position: 'relative'
            }}>
            <div className="left-pane-container" style={{ flex: '1' }}>
              <div className="full-screen-sidebar" style={{ transform: 'translate3d(0, 0, 0)' }}>
                {/* Content for left pane */}
                <QuestionAreaIndividual />
              </div>
            </div>
          </div>
          <div
            className="gutter-horizontal"
            style={{
              width: '12px',
              marginLeft: '12px' // Adjust margin to create gutter effect
            }}></div>
          <div
            className="fs-right-pane"
            style={{
              width: 'calc(55.5% - 6px)',
              position: 'relative'
            }}>
            <div className="challenge-page-wrap theme-m-content">
              <section className="code-editor-section split">
                {/* Content for right pane */}
                <Editor />
              </section>
            </div>
          </div>
        </div>
      ))}
    </>
  );
}

export default QuestionRowIndividual;
